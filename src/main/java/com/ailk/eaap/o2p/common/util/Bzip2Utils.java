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

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;

import com.asiainfo.foundation.log.Logger;

public class Bzip2Utils extends CompressUtils implements ICompress {
	
	private static final Logger logger = Logger.getLog(Bzip2Utils.class);
	
    private List<File> bzip(File[] files, Boolean delete) throws CompressException {
        if (files == null || files.length == 0) {
        	logger.error("Array files must be not null.");
        	return null;
        }
        List<File> fs = new ArrayList<File>();
        for (int i = 0, size = files.length; i < size; i++) {
            File file = files[i];
            try {
                if (file.isDirectory()) {
                    fs.addAll(bzip(file.listFiles(), delete));
                } else {
                    fs.add(bzip(file, delete));
                }
            } catch (Exception e) { // 删除冗余文件
                for (int c = 0, siz = fs.size(); c < siz; c++) {
                    if(fs.get(c).delete()){
                    	 throw new CompressException(fs.get(c)+" delete error");
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
     * @throws java.io.IOException
     */
    private void bzip(InputStream is, OutputStream os)
            throws IOException {
        BZip2CompressorOutputStream gos = null;
        try {
            gos = new BZip2CompressorOutputStream(os);
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
     */
    private File bzip(File file, boolean delete) throws CompressException {
        if (file == null || !file.isFile()) {
            throw new CompressException("Bzip must be file and not empty.");
        }
        FileInputStream fis = null;
        FileOutputStream fos = null;
        File strFile = new File(file.getAbsolutePath() + BZIP_EXT + SUFFIX);
        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(strFile);
            bzip(fis, fos);
            fos.flush();
        } catch (IOException e) { // 删除冗余文件
            if (strFile.exists()){
            	  if(strFile.delete()){
                 	 throw new CompressException(strFile.getAbsolutePath()+" delete error");
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
        File file1 = new File(file.getPath() + BZIP_EXT);
        if(strFile.renameTo(file1)){
          	 throw new CompressException(strFile.getAbsolutePath()+" rename error");
        }
        if (delete) {
        	 if(! file.delete()){
                	logger.error("file {0} delete fail ", file.getAbsoluteFile());
            }
        }
        return file1;
    }

    private List<File> bdezip(File[] files, Boolean delete) throws CompressException {
        if (files == null || files.length == 0) {
        	logger.error("Array files must be not null.");
        	return null;
        }
        List<File> fs = new ArrayList<File>();
        for (int i = 0, size = files.length; i < size; i++) {
            File file = files[i];
            try {
                if (file.isDirectory()) {
                    fs.addAll(bdezip(file.listFiles(), delete));
                } else {
                    fs.add(bdezip(file, delete));
                }
            } catch (Exception e) { // 删除冗余文件
                for (int c = 0, siz = fs.size(); c < siz; c++) {
                    if(fs.get(c).delete()){
                    	 throw new CompressException(fs.get(c)+" delete error");
                    }
                }
                throw new CompressException(e.getMessage());
            }
        }
        return fs;
    }

    public File bdezip(File file, boolean delete) throws CompressException {
        if (file == null || !file.isFile()) {
            throw new CompressException("Unbzip must be file and not empty.");
        }
        FileInputStream fis = null;
        FileOutputStream fos = null;
        final String output_name = file.getAbsolutePath().replace(BZIP_EXT, "");
        File f = new File(output_name + SUFFIX);
        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(f);
            bdezip(fis, fos);
            fos.flush();
        } catch (IOException e) { // 删除冗余文件
            if (f.exists()) {
            	 if(f.delete()){
                	 throw new CompressException(f.getAbsolutePath()+" delete error");
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
        	 throw new CompressException(output_name + SUFFIX+" rename error");
        }
        if (delete) {
        	 if(! file.delete()){
                	logger.error("file {0} delete fail ", file.getAbsoluteFile());
            }
        }
        return file1;
    }

    /**
     * 数据解压缩
     *
     * @param is
     * @param os
     * @throws java.io.IOException
     */
    private void bdezip(InputStream is, OutputStream os)
            throws IOException {
        BZip2CompressorInputStream gis = null;
        int count;
        byte data[] = new byte[BUFFEREDSIZE * 10];
        try {
            gis = new BZip2CompressorInputStream(is);
            while ((count = gis.read(data, 0, BUFFEREDSIZE * 10)) != -1) {
                os.write(data, 0, count);
            }
            os.flush();
        } finally {
            if(null != gis) {
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
            bzip(bais, baos);
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
        return compress(new File(sourceFilePath));
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
                    fs.addAll(bzip(file.listFiles(), delete));
                } else {
                    fs.add(bzip(file, delete));
                }
            } catch (Exception e) { // 删除冗余文件
                for (int c = 0, siz = fs.size(); c < siz; c++) {
                	   if( fs.get(c).delete()){
                      	 throw new CompressException(fs.get(c)+" delete error");
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
            fs.add(bzip(sourceFile, delete));
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
            bdezip(bais, baos);
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
            fs.add(bdezip(sourceFile, delete));
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
                    fs.addAll(bdezip(file.listFiles(), delete));
                } else {
                    fs.add(bdezip(file, delete));
                }
            } catch (Exception e) { // 删除冗余文件
                for (int c = 0, siz = fs.size(); c < siz; c++) {
                    if(fs.get(c).delete()){
                    	 throw new CompressException(fs.get(c)+" delete error");
                    }
                }
                throw new CompressException(e.getMessage());
            }
        }
        return fs;
    }
}
