package com.ailk.eaap.o2p.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;

import com.asiainfo.foundation.log.Logger;

/**
 * Created by david on 14-9-16.
 */
public class GzipUtils extends CompressUtils implements ICompress {
	
	private static final Logger logger = Logger.getLog(GzipUtils.class);

    private List<File> gzip(File[] files, Boolean delete) throws CompressException {
        List<File> fs = new ArrayList<File>();
        for (int i = 0, size = files.length; i < size; i++) {
            File file = files[i];
            try {
                if (file.isDirectory()) {
                    File []files1 = file.listFiles();
                    if(files1 != null && files1.length > 0) {
                        fs.addAll(gzip(files1, delete));
                    }
                } else {
                    fs.add(gzip(file, delete));
                }
            } catch (Exception e) { // 删除冗余文件
                for (int c = 0, siz = fs.size(); c < siz; c++) {
                    if(!fs.get(c).delete()){
                    	logger.error("fs.get(c): {0} delete() error", fs.get(c).getAbsoluteFile());
                    }
                }
                throw new CompressException(e.getMessage());
            }
        }
        return fs;
    }

    /**
     * 数据压缩
     *
     * @param is
     * @param os
     */
    private void gzip(InputStream is, OutputStream os)
            throws IOException {
        GzipCompressorOutputStream gos = null;
        try {
            gos = new GzipCompressorOutputStream(os);
            int count;
            byte data[] = new byte[BUFFEREDSIZE * 10];
            while ((count = is.read(data, 0, BUFFEREDSIZE * 10)) != -1) {
                gos.write(data, 0, count);
            }
            gos.flush();
        } finally {
            if (null != gos) {
                try {
                    gos.close();
                } catch (IOException e) {
                	logger.error("gos.close() error", e);
                }
            }
        }
    }

    /**
     * 文件压缩
     *
     * @param file
     * @param delete 是否删除原始文件
     * @throws CompressException
     */
    private File gzip(File file, boolean delete) throws CompressException {
        if (file == null || !file.isFile()) {
            throw new CompressException("Gzip must be file and not empty.");
        }
        FileInputStream fis = null;
        FileOutputStream fos = null;
        final String str = file.getAbsolutePath() + GZIP_EXT + SUFFIX;
        File f = new File(str);
        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(f);
            gzip(fis, fos);
            fos.flush();
        } catch (IOException e) { // 删除冗余文件
            if (f.exists()) {
            	if(!f.delete()){
                	logger.error("f: {0} delete() error", f.getAbsoluteFile());
                }
            }
            throw new CompressException(e.getMessage());
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                	logger.error("fis.close() error", e);
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                	logger.error("fos.close() error", e);
                }
            }
        }
        File file1 = new File(file.getPath() + GZIP_EXT);
        if(!new File(str).renameTo(file1)){
         	logger.error("str: {0} rename error",str );
        }
        if (delete) {
        	   if(!file.delete()){
               	logger.error("file {0} delete fail", file.getAbsolutePath());
               }
        }
        return file1;
    }

    /**
     * List解压缩
     *
     * @param files
     * @param delete
     * @return
     */
    private List<File> gdezip(File []files, Boolean delete) throws CompressException {
        if (files == null || files.length == 0) {
        	logger.error("Array files must be not null.");
        	return null;
        }
        List<File> fs = new ArrayList<File>();
        for (int i = 0, size = files.length; i < size; i++) {
            File file = files[i];
            try {
                if (file.isDirectory()) {
                    fs.addAll(gdezip(file.listFiles(), delete));
                } else {
                    fs.add(gdezip(file, delete));
                }
            } catch (Exception e) { // 删除冗余文件
                for (int c = 0, siz = fs.size(); c < siz; c++) {
                	 if(!fs.get(c).delete()){
                     	logger.error("fs.get(c): {0} delete() error", fs.get(c).getAbsoluteFile());
                     } 
                }
                throw new CompressException(e.getMessage());
            }
        }
        return fs;
    }

    /**
     * 文件解压缩
     *
     * @param file
     * @param delete 是否删除原始文件
     */
    private File gdezip(File file, boolean delete) throws CompressException {
        if(file == null || !file.isFile()) {
            throw new CompressException("Ungzip must be file and not empty.");
        }
        FileInputStream fis = null;
        FileOutputStream fos = null;
        final String output_name = file.getAbsolutePath().replace(GZIP_EXT, "");
        File f = new File(output_name + SUFFIX);
        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(f);
            gdezip(fis, fos);
            fos.flush();
        } catch (IOException e) { // 删除冗余文件
           
            if (f.exists()) {
            	 if(!f.delete()){
                 	logger.error("f: {0} delete() error", f.getAbsoluteFile());
                 }
            }
            throw new CompressException(e.getMessage());
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                	logger.error("fis.close() error", e);
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                	logger.error("fos.close() error", e);
                }
            }
        }
        File file1 = new File(output_name);
        if(new File(output_name + SUFFIX).renameTo(file1)){
        	logger.error("file {0} delete fail", output_name + SUFFIX);
        }
        if (delete) {
            if(!file.delete()){
            	logger.error("file {0} delete fail", file.getAbsolutePath());
            }
        }
        return file1;
    }

    /**
     * 数据解压缩
     *
     * @param fis
     * @param fos
     * @throws java.io.IOException
     */
    public static void gdezip(InputStream fis, OutputStream fos) throws IOException {
        MultiMemberGZIPInputStream gis = null;
        int count;
        byte data[] = new byte[BUFFEREDSIZE * 10];
        try {
            gis = new MultiMemberGZIPInputStream(fis);
            while ((count = gis.read(data, 0, BUFFEREDSIZE * 10)) != -1) {
                fos.write(data, 0, count);
            }
            fos.flush();
        } finally {
            if (null != gis) {
                try {
                    gis.close();
                } catch (IOException e) {
                	logger.error("gis.close() error", e);
                }
            }
        }
    }

    @Override
    public byte[] compress(byte[] bytes) throws IOException {
        ByteArrayInputStream bais = null;
        ByteArrayOutputStream baos = null;
        byte[] output;
        try {
            bais = new ByteArrayInputStream(bytes);
            baos = new ByteArrayOutputStream();
            // 压缩
            gzip(bais, baos);
            output = baos.toByteArray();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                	logger.error("baos.close() error", e);
                }
            }
            if (bais != null) {
                try {
                    bais.close();
                } catch (IOException e) {
                	logger.error("bais.close() error", e);
                }
            }
        }
        return output;
    }

    @Override
    public List<File> compress(String sourceFilePath) throws CompressException {
        return compress(sourceFilePath, false);
    }

    @Override
    public List<File> compress(File sourceFile) throws CompressException {
        return compress(sourceFile, false);
    }

    @Override
    public List<File> compress(List<File> sourceFiles) throws CompressException {
        return compress(sourceFiles, false);
    }

    @Override
    public List<File> compress(List<File> sourceFiles, Boolean delete) throws CompressException {
        if (sourceFiles == null || sourceFiles.size() == 0) {
        	logger.error("Array files must be not null.");
        	return null;
        }
        List<File> fs = new ArrayList<File>();
        for (int i = 0, size = sourceFiles.size(); i < size; i++) {
            File file = sourceFiles.get(i);
            try {
                if (file.isDirectory()) {
                    File []files = file.listFiles();
                    if(files != null && files.length > 0) {
                        fs.addAll(gzip(files, delete));
                    }
                } else {
                    fs.add(gzip(file, delete));
                }
            } catch (Exception e) { // 删除冗余文件
                for (int c = 0, siz = fs.size(); c < siz; c++) {
                	 if(!fs.get(c).delete()){
                     	logger.error("fs.get(c): {0} delete() error", fs.get(c).getAbsoluteFile());
                     }
                }
                throw new CompressException(e.getMessage());
            }
        }
        return fs;
    }

    @Override
    public List<File> compress(String sourceFilePath, boolean delete) throws CompressException {
        return compress(new File(sourceFilePath), delete);
    }

    @Override
    public List<File> compress(File sourceFile, boolean delete) throws CompressException {
        List<File> fs = new ArrayList<File>();
        if(sourceFile.isDirectory()) {
            File []files = sourceFile.listFiles();
            if(files != null && files.length > 0) {
                for(int i=0, size=files.length; i<size; i++) {
                    fs.addAll(compress(files[i], delete));
                }
            }
        } else {
            fs.add(gzip(sourceFile, delete));
        }
        return fs;
    }

    @Override
    public byte[] uncompress(byte[] bytes) throws IOException {
        ByteArrayInputStream bais = null;
        ByteArrayOutputStream baos = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            baos = new ByteArrayOutputStream();
            // 解压缩
            gdezip(bais, baos);
            bytes = baos.toByteArray();
            baos.flush();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                	logger.error("baos.close() error", e);
                }
            }
            if (bais != null) {
                try {
                    bais.close();
                } catch (IOException e) {
                	logger.error("bais.close() error", e);
                }
            }
        }
        return bytes;
    }

    @Override
    public List<File> uncompress(String sourceFilePath) throws CompressException {
        return uncompress(sourceFilePath, false);
    }

    @Override
    public List<File> uncompress(File sourceFile) throws CompressException {
        return uncompress(sourceFile, false);
    }

    @Override
    public List<File> uncompress(List<File> sourceFiles) throws CompressException {
        return uncompress(sourceFiles, false);
    }

    @Override
    public List<File> uncompress(String sourceFilePath, boolean delete) throws CompressException {
        return uncompress(new File(sourceFilePath), delete);
    }

    @Override
    public List<File> uncompress(File sourceFile, boolean delete) throws CompressException {
        List<File> fs = new ArrayList<File>();
        if(sourceFile.isDirectory()) {
            File []files = sourceFile.listFiles();
            if(files != null && files.length > 0) {
                for(int i=0, size=files.length; i<size; i++) {
                    fs.addAll(uncompress(files[i], delete));
                }
            }
        } else {
            fs.add(gdezip(sourceFile, delete));
        }
        return fs;
    }

    @Override
    public List<File> uncompress(List<File> sourceFiles, Boolean delete) throws CompressException {
        if (sourceFiles == null || sourceFiles.size() == 0) {
        	logger.error("Array files must be not null.");
        	return null;
        }
        List<File> fs = new ArrayList<File>();
        for (int i = 0, size = sourceFiles.size(); i < size; i++) {
            File file = sourceFiles.get(i);
            try {
                if (file.isDirectory()) {
                    fs.addAll(gdezip(file.listFiles(), delete));
                } else {
                    fs.add(gdezip(file, delete));
                }
            } catch (Exception e) { // 删除冗余文件
                for (int c = 0, siz = fs.size(); c < siz; c++) {
                	 if(!fs.get(c).delete()){
                     	logger.error("fs.get(c): {0} delete() error", fs.get(c).getAbsoluteFile());
                     }
                }
                throw new CompressException(e.getMessage());
            }
        }
        return fs;
    }
}
