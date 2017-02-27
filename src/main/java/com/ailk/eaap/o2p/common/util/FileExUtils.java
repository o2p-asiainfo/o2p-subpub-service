package com.ailk.eaap.o2p.common.util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.apache.commons.io.FileUtils.forceMkdir;
import static org.apache.commons.io.FileUtils.getTempDirectory;

/**
 * Created by david on 14-9-9.
 */
public final class FileExUtils {

    public static final String SEPARATOR = File.separator;

    public static final String SUFFIX = ".tmp";
    
    private FileExUtils(){
		
	}
    
    public static void deleteFile(File file) {
        if(file.isDirectory()) {
            for(File f : file.listFiles()) {
                deleteFile(f);
            }
        } else if(file.isFile()) {
        	deleteFile(file);
        }
    }

    /**
     * 十六进制字符串装十进制
     *
     * @param hex
     *            十六进制字符串
     * @return 十进制数值
     */
    public static int hexStringToAlgorism(String hex) {
        hex = hex.toUpperCase();
        int max = hex.length();
        int result = 0;
        for (int i = max; i > 0; i--) {
            char c = hex.charAt(i - 1);
            int algorism = 0;
            if (c >= '0' && c <= '9') {
                algorism = c - '0';
            } else {
                algorism = c - 55;
            }
            result += Math.pow(16, max - i) * algorism;
        }
        return result;
    }

    public static int hexStringToAlgorismSub(String hex) {
        return hexStringToAlgorism(hex.substring(2));
    }

    public static String getTimeByFormat(String format) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static int getFileSize(List files) {
        return files.size();
    }

    public static List deepCopy(List src) throws IOException, ClassNotFoundException{
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in =new ObjectInputStream(byteIn);
        return (List)in.readObject();
    }

    public static <T> List<T> deepCopyT(List<T> src) {
        List<T> newList = new ArrayList<T>();
        for(T t : src) {
            newList.add(t);
        }
        return newList;
    }

    /**
     * 在默认目录下获得一个临时文件
     * 但是不创建
     * 默认使用.tmp后缀
     *
     * @return
     */
    public static File getTemplateFile() {
        return getTemplateFile(getTempDirectory());
    }

    /**
     * 在指定目录下获得一个临时文件
     * 但是不创建
     * 默认使用.tmp后缀
     *
     * @param directoryFile
     * @return
     */
    public static File getTemplateFile(File directoryFile) {
        UUID uuid = UUID.randomUUID();
        return new File(directoryFile.getPath() + SEPARATOR + uuid + SUFFIX);
    }

    /**
     * 在指定目录下获得一个临时文件
     * 但是不创建
     * 默认使用.tmp后缀
     *
     * @param directory 指定目录
     * @return
     */
    public static File getTemplateFile(String directory) {
        return getTemplateFile(new File(directory));
    }

    /**
     * 在默认目录下创建一个临时目录
     *
     * @return
     */
    public static File getDefaultTemplateDirectory() {
        return getDefaultTemplateDirectory(getTempDirectory());
    }

    /**
     * 在指定目录下获得一个临时文件
     *
     * @param directoryFile
     * @return
     */
    public static File getDefaultTemplateDirectory(String directoryFile) {
        return getDefaultTemplateDirectory(new File(directoryFile));
    }

    /**
     * 在指定目录下获得一个临时文件
     *
     * @param directoryFile
     * @return
     */
    public static File getDefaultTemplateDirectory(File directoryFile) {
        UUID uuid = UUID.randomUUID();
        return new File(directoryFile.getPath() + SEPARATOR + uuid);
    }

    /**
     * 创建指定临时目录
     *
     * @param directory
     * @throws IOException 目录已存在, 创建失败
     */
    public static void createTemplateDirectory(File directory) throws IOException {
        forceMkdir(directory);
    }

    /**
     * 创建指定临时目录
     *
     * @param directory
     * @throws IOException 目录已存在, 创建失败
     */
    public static void createTemplateDirectory(String directory) throws IOException {
        createTemplateDirectory(new File(directory));
    }
}
