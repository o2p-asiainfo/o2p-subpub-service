package com.ailk.eaap.o2p.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.asiainfo.foundation.log.Logger;

public final class Constant {
	
		private final static Logger logger = Logger.getLog(Constant.class);
	
		//任务状态 0:启动时未加载
		public static final String TASK_STATE_NO = "0";
		//任务状态 1:启动时加载
		public static final String TASK_STATE_YES= "1";
		
		//订阅分发类型：1:文件类型，2：实时接口类型
		public static final Integer FILE_TYPE = 1;
		public static final Integer INTFACE_TYPE = 2;
		
		//订阅分发状态：1成功，2：失败，3：等待重新发送，4：重新发送中
		public static final Integer SUB_SCCCESS = 1;
		public static final Integer SUB_FAIL = 2;
		public static final Integer SUB_AGAIN = 3;
		public static final Integer SUB_AGAIN_ING = 4;
		
		//目录类型：L：本地，R：远程
		public static final String LOCAL_DIR = "L";
		public static final String REMOTE_DIR = "R";
		
		// 搬迁后的操作 1：搬迁后删除；2：搬迁后删除并归档；
		public static final String POST_ACTION_DEL = "1";
		public static final String POST_ACTION_ARCHIVE_AND_DEL = "2";
		
		public static final String ATTR_SPEC_CODE_POST_READ_ACTION = "POST_READ_ACTION";

		public static final String ATTR_SPEC_CODE_MOVE_TAR_DIR = "FILE_MOVE_TAR_DIR";

		public static final String ATTR_SPEC_CODE_ARCHIVE_DIR_PATH = "FILE_ARCHIVE_DIR";

		public static final String ATTR_SPEC_CODE_IS_SCAN_SUB_DIR = "IS_SCAN_SUB_DIR";
		
		/** 文件名不存在 **/
	    public static final int ERROR_CODE_9234 = 9234;

	    public static final String ZIP_SRC_TAR = "ZIP_SRC_TAR"; //  暂停使用
	    public static final String ZIP_REMOTE_ATTR = "ZIP_REMOTE_ATTR"; //  远程登录属性
	    public static final String FILE_TAR_PATH = "FILE_TAR_PATH";   //  压缩文件存放路径
	    public static final String ZIP_TAR_NAME = "ZIP_TAR_NAME";   //  压缩文件名
	    public static final String ZIP_DEL_SRC_PREFIX = "ZIP_DEL_SRC_PREFIX";   //  压缩源文件删除前缀
	    public static final String ZIP_INVOKED_ACT = "ZIP_INVOKED_ACT";   //  压缩源文件删除前缀

	    public static final String ZIP_OR_UNZIP = "ZIP_OR_UNZIP";   //  压缩或解压缩
	    public static final String ZIPING = "ZIP";   // ZIP
	    public static final String UNZIPING = "UNZIP";   // ZIP

	    public static final String ZIP_TYPE = "ZIP_TYPE";   // 压缩类型
	    public static final String ZIP_TYPE_ZIP = "ZIP";   // ZIP
	    public static final String ZIP_TYPE_GZIP = "GZIP";   // GZIP
	    public static final String ZIP_TYPE_BZIP2 = "BZIP2";   // BZIP
	    public static final String ZIP_TYPE_TAR = "TAR";   // TAR
	    public static final String ZIP_TYPE_TAR_GZIP = "TAR_GZIP";   // TAR_GZIP
	    public static final String ZIP_TYPE_TAR_BZIP2 = "TAR_BZIP2";   // TAR_BZIP2

	    public static final String ZIP_METHOD_M = "M";  //  文件压缩后, 远程归档, 源文件改变路径
	    public static final String ZIP_METHOD_S = "S";  //  文件压缩后, 不变
	    public static final String ZIP_METHOD_D = "D";  //  文件压缩后, 删除
	    
	    public final static String FILE_SCAN_SUB_DIR = "FileScanSubDir";
	    public final static String YES = "Y";
	    public final static String NO = "N";
		
		private Constant(){
			
		}
		
		public static String replacePath(String path){
			try{
				Pattern p = Pattern.compile("#(.*?):(.*?)#");
				Matcher m = p.matcher(path);
				String sign = null;
				String exp = null;
				String expStr = null;
				while(m.find()){
					expStr = m.group(0);
					sign = m.group(1);
					exp = m.group(2);
					if("DATE".equalsIgnoreCase(sign)){
						SimpleDateFormat sf = new SimpleDateFormat(exp);
						String newPath = sf.format(new Date());
						path = path.replaceAll(expStr,newPath);
					}
				}
				
			}catch(Exception e){
				logger.error("Path replace error,the path is {0},exception is {1}",new Object[]{path,e});
			}
			return path;
		}
		
}
