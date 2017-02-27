package com.ailk.eaap.o2p.route;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.ailk.eaap.o2p.common.Constant;
import com.ailk.eaap.o2p.common.util.Bzip2Utils;
import com.ailk.eaap.o2p.common.util.CompressException;
import com.ailk.eaap.o2p.common.util.CompressUtils;
import com.ailk.eaap.o2p.common.util.GzipUtils;
import com.ailk.eaap.o2p.common.util.IArchive;
import com.ailk.eaap.o2p.common.util.ICompress;
import com.ailk.eaap.o2p.common.util.TarUtils;
import com.ailk.eaap.o2p.common.util.ZipUtils;
import com.ailk.eaap.op2.common.EAAPException;
import com.ailk.eaap.op2.common.EAAPTags;
import com.ailk.eaap.op2.serviceagent.common.EOPDomain;
import com.ailk.eaap.op2.serviceagent.common.ErrorDomain;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.serviceagent.route.service.EndpointProcessor;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.Endpoint;
import com.ailk.eaap.op2.bo.EndpointAttr;

/**
 * Created by david on 14-9-3.
 */
public class ZipFileEndPointProcessor implements EndpointProcessor {

    private final static Logger logger = Logger.getLog(ZipFileEndPointProcessor.class);

    private String err = "";
    public MessageBO process(Endpoint endpoint, MessageBO msg) throws EAAPException {
    	endpoint.setEndpointDesc(EOPDomain.ENDPOINT_DESC_FAIL);
    	StringBuffer response = new StringBuffer();
    	response
		.append(" <ENDPOINTID=")
		.append(endpoint.getEndpointId())
		.append(">");
    	
        String tarDir = initZip(msg);
        List<File> files = new ArrayList<File>();
        Object object = msg.getMsgBody();
        if (object instanceof File[]) {
    		File[] srcFiles = (File[]) object;
            files.addAll(Arrays.asList(srcFiles));
        } else if(object instanceof File) {
            File file = (File) object;
            files.add(file);
        } else {
            throw new EAAPException(EAAPTags.SEG_DRAVER_SIGN, ErrorDomain.ERROR_CODE_9999, "compress not file.");
        }
        if(files.size()<1){
        	return msg;
        }
        List<EndpointAttr> attrs = endpoint.getEndpointAttrList();
        String returnZip = null;
        try {
            returnZip = zip(response,files, attrs, tarDir, msg);
        } catch (Exception e) {
        	logger.error("zip endpoint "+endpoint.getEndpointId()+" error", e);
            throw new EAAPException(EAAPTags.SEG_DRAVER_SIGN, ErrorDomain.ERROR_CODE_9999, e.getMessage(),e);
        }
        if (returnZip != null) {
            object = msg.getMsgBody();
            if (object instanceof File[]) {
                File[] srcFiles = (File[]) object;
            	response.append(" file:").append(returnZip);
            	msg.setSuccessNum(srcFiles.length);
            	msg.setOutputSuccessFileNum(srcFiles.length);
                msg.setMsgBody(new File[]{new File(returnZip)});
            } else {
                msg.setMsgBody(new File(returnZip));
                msg.setSuccessNum(1);
                msg.setOutputSuccessFileNum(1);
                response.append(" file: ").append(returnZip);
            }
        }
        msg.setResponseDes(msg.getResponseDes()+response.toString());
        endpoint.setEndpointDesc(EOPDomain.ENDPOINT_DESC_SUCCESS);
        return msg;
    }

    public void clear() {

    }

    public void subtraThreadNum(String servId) throws EAAPException {

    }


    /**
     * 初始化文件地址
     */
    private String initZip(MessageBO msg) {
    	
     File	tempDir =  new File(msg.getTempFileDirName());
     return tempDir.getParent()+File.separator+"zip";
    }

    /**
     * 压缩文件
     *
     * @param attrs
     * @return
     */
    private String zip(StringBuffer response,List<File> files, List<EndpointAttr> attrs, String tarDir, MessageBO bo) throws Exception {
    	response
    	.append("#")
    	.append(new java.sql.Timestamp(System.currentTimeMillis()).toString())
    	.append("#");
    	
        String name = "";
        String type = Constant.ZIP_TYPE_ZIP;
        boolean act = false;
        boolean isZip = true;
        for (Iterator<EndpointAttr> iterator = attrs.iterator(); iterator.hasNext(); ) {
            EndpointAttr attr = iterator.next();
            if (Constant.FILE_TAR_PATH.equalsIgnoreCase(attr.getAttrSpecCode()) && org.springframework.util.StringUtils.hasText(attr.getAttrValue())) {
                tarDir = attr.getAttrValue()+File.separator+"zip";
            } else if (Constant.ZIP_TAR_NAME.equalsIgnoreCase(attr.getAttrSpecCode()) && org.springframework.util.StringUtils.hasText(attr.getAttrValue())) {
                name = CompressUtils.dynamicFileName(attr.getAttrValue());
            } else if (Constant.ZIP_TYPE.equals(attr.getAttrSpecCode())) {
                type = attr.getAttrValue();
            } else if (Constant.ZIP_INVOKED_ACT.equals(attr.getAttrSpecCode())) {
                if (Constant.ZIP_METHOD_D.equals(attr.getAttrValue())) {
                    act = true;
                }
            } else if (Constant.ZIP_OR_UNZIP.equals(attr.getAttrSpecCode())) {
                if (Constant.UNZIPING.equalsIgnoreCase(attr.getAttrValue())) {
                    isZip = false;
                }
            }
        }
        if(logger.isDebugEnabled()){
        	logger.debug(" zip tarDir : {0}",tarDir);
        }
        String tempFileDirName = bo.getTempFileDirName();
        //创建zip临时目录
        File tmpFile = new File(tarDir);
        if (!tmpFile.exists()) {
            try {
                FileUtils.forceMkdir(tmpFile);
            } catch (IOException e) {
                err = "SerInvokeInsId : " + bo.getSerInvokeIns().getSerInvokeInsId() + ", template file, template file exists, failed. exception content is :" + e.getMessage();
                throw new BusinessException(Constant.ERROR_CODE_9234, err);
            }
        }
        bo.setTempFileDirName(tarDir);
        return getPath(response,tarDir, name, type, act, files, isZip, bo, tempFileDirName);
    }

    /**
     * 获得压缩文件最终地址
     *
     * @param tarDir
     * @param name
     * @param type
     * @param act
     * @param files
     * @param dels
     * @return
     */
    private String getPath(StringBuffer response,String tarDir, String name, String type, boolean act, List<File> files,  boolean isZip, MessageBO bo, String tempFileDirName) throws Exception {
        if (files == null || files.size() == 0) {
        	logger.info("zip endpoint get Files is empty. ");
        	return null;
        }
        int num = 0;
        String path = null;
        if (isZip) {
        	path = zipPath(response, tarDir, name, type, act, files, bo, path, num, tempFileDirName);
        } else {
        	unzipPath(response, tarDir, type, act, files, bo, num, tempFileDirName);
        }
        return path;
    }

	private void unzipPath(StringBuffer response, String tarDir, String type,
			boolean act, List<File> files, MessageBO bo, int num, String tempFileDirName)
			throws CompressException, IOException {
		IArchive iArchive;
		ICompress iCompress;
		bo.setEndPointSpec(" unzip file");
		response.append(" unzip ");
		if (files.size() > 1) {
		    if (StringUtils.isEmpty(tarDir)) {
		        throw new CompressException("Target file name is not empty or Target directory is not empty.");
		    }
		} else {
		    tarDir = StringUtils.isEmpty(tarDir) ? files.get(0).getParent() : tarDir;
		}
		if (Constant.ZIP_TYPE_ZIP.equalsIgnoreCase(type)) {
		    iArchive = new ZipUtils();
		    num =setFile(iArchive.dearchive(files, new File(tarDir), act), bo);
		} else if (Constant.ZIP_TYPE_TAR.equalsIgnoreCase(type)) {
		    iArchive = new TarUtils();
		    num =setFile(iArchive.dearchive(files, new File(tarDir), act), bo);
		} else if (Constant.ZIP_TYPE_TAR_GZIP.equalsIgnoreCase(type)) {
		    iCompress = new GzipUtils();
		    iArchive = new TarUtils();
		    List<File> fileList = iCompress.uncompress(files); //先不删除源文件
		    try {
		    	num = setFile(iArchive.dearchive(fileList, new File(tarDir)), bo);
		    } finally {
		        if (fileList != null && fileList.size() > 0) {   // 删除 压缩时产生的文件
		            for (int i = 0, size = fileList.size(); i < size; i++) {
		                CompressUtils.delFiles(fileList.get(i));
		            }
		        }
		    }
		    if (act) {
		        for (int i = 0, size = files.size(); i < size; i++) {
		            CompressUtils.delFiles(files.get(i));
		        }
		    }
		} else if (Constant.ZIP_TYPE_TAR_BZIP2.equalsIgnoreCase(type)) {
		    iCompress = new Bzip2Utils();
		    iArchive = new TarUtils();
		    List<File> fileList = iCompress.uncompress(files); //先不删除源文件
		    try {
		    	num =setFile(iArchive.dearchive(fileList, new File(tarDir)), bo);
		    } finally {
		        if (fileList != null && fileList.size() > 0) {   // 删除 压缩时产生的文件
		            for (int i = 0, size = fileList.size(); i < size; i++) {
		                CompressUtils.delFiles(fileList.get(i));
		            }
		        }
		    }
		    if (act) {
		        for (int i = 0, size = files.size(); i < size; i++) {
		            CompressUtils.delFiles(files.get(i));
		        }
		    }
		} else if (Constant.ZIP_TYPE_GZIP.equalsIgnoreCase(type)) {
			//GZIP方式不改变临时目录
            bo.setTempFileDirName(tempFileDirName);
		    iCompress = new GzipUtils();
		    num =setFile(iCompress.uncompress(files, act), bo);
		} else if (Constant.ZIP_TYPE_BZIP2.equalsIgnoreCase(type)) {
			//不改变临时目录
            bo.setTempFileDirName(tempFileDirName);
		    iCompress = new Bzip2Utils();
		    num =setFile(iCompress.uncompress(files, act), bo);
		}
		if(logger.isDebugEnabled()){
			logger.debug("unzip num:{0}", num);
		}
		response.append(" successNum:").append(num);
	}

	private String zipPath(StringBuffer response, String tarDir, String name,
			String type, boolean act, List<File> files, MessageBO bo,
			String path,Integer num, String tempFileDirName) throws CompressException, FileNotFoundException {
		IArchive iArchive;
		ICompress iCompress;
		bo.setEndPointSpec(" zip file");
		response.append(" zip ");
		if (files.size() > 1) {
		    if (StringUtils.isEmpty(name) || StringUtils.isEmpty(tarDir)) {
		        throw new CompressException("Target file name is not empty or Target directory is not empty.");
		    }
		} else {
		    name = StringUtils.isEmpty(name) ? files.get(0).getName() : name;
		    tarDir = StringUtils.isEmpty(tarDir) ? files.get(0).getParent() : tarDir;
		}
		if (Constant.ZIP_TYPE_ZIP.equalsIgnoreCase(type)) {
		    iArchive = new ZipUtils();
		    path = iArchive.archive(files, tarDir, name, act);
		} else if (Constant.ZIP_TYPE_TAR.equalsIgnoreCase(type)) {
		    iArchive = new TarUtils();
		    path = iArchive.archive(files, tarDir, name, act);
		} else if (Constant.ZIP_TYPE_BZIP2.equalsIgnoreCase(type)) {
			//不改变临时目录
            bo.setTempFileDirName(tempFileDirName);
		    iCompress = new Bzip2Utils();
		    num = setFile(iCompress.compress(files, act), bo);
		} else if (Constant.ZIP_TYPE_GZIP.equalsIgnoreCase(type)) {
			//GZIP方式不改变临时目录
            bo.setTempFileDirName(tempFileDirName);
		    iCompress = new GzipUtils();
		    num =setFile(iCompress.compress(files, act), bo);
		} else if (Constant.ZIP_TYPE_TAR_GZIP.equalsIgnoreCase(type)) {
		    iArchive = new TarUtils();
		    path = iArchive.archive(files, tarDir, name);   // 先不删除源文件
		    iCompress = new GzipUtils();
		    try {
		    	num = setFile(iCompress.compress(path, act), bo);
		    } finally {
		        if (path != null) {  // 删除 归档时产生的文件
		            if(!new File(path).delete()){
		            	logger.error("path {0} delete fail", path);
		            }
		            
		        }
		    }
		    if (act) {  // 如果压缩也成功, 根据提示 确定是否删除 源文件
		        for (int i = 0, size = files.size(); i < size; i++) {
		            CompressUtils.delFiles(files.get(i));
		        }
		    }
		    path = null;
		} else if (Constant.ZIP_TYPE_TAR_BZIP2.equalsIgnoreCase(type)) {
		    iArchive = new TarUtils();
		    path = iArchive.archive(files, tarDir, name);   // 先不删除源文件
		    iCompress = new Bzip2Utils();
		    try {
		    	num =setFile(iCompress.compress(path, act), bo);
		    } finally {
		        if (path != null) {  // 删除 归档时产生的文件
		        	CompressUtils.delFiles(new File(path));
		        }
		    }
		    if (act) {  // 如果压缩也成功, 根据提示 确定是否删除 源文件
		        for (int i = 0, size = files.size(); i < size; i++) {
		            CompressUtils.delFiles(files.get(i));
		        }
		    }
		    path = null;
		}
		if(logger.isDebugEnabled()){
			logger.debug("zip num:{0}", num);
		}
		return path;
	}

    private int setFile(List<File> file, MessageBO bo) {
    	int num = 1;
        Object obj = bo.getMsgBody();
        if (obj instanceof File[]) {
            bo.setMsgBody(file.toArray(new File[file.size()]));
            num = file.size();
        } else if(obj instanceof File) {
            bo.setMsgBody(file.get(0));
        }
		return num;
    }

}