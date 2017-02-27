/** 
 * Project Name:o2p-subpub-service-2.6 
 * File Name:SftpTest.java 
 * Package Name:com.ailk.eaap.o2p.util.file.remote.session.sftp 
 * Date:2016年4月19日下午4:12:23 
 * Copyright (c) 2016, www.asiainfo.com All Rights Reserved. 
 * 
*/  
  
package com.ailk.eaap.o2p;  

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.ailk.eaap.o2p.route.DownloadProcessor;
import com.ailk.eaap.op2.bo.EndpointAttr;
import com.ailk.eaap.op2.bo.TechImpl;
import com.ailk.eaap.op2.serviceagent.common.EOPDomain;

/** 
 * ClassName:SftpTest  
 * Function: TODO ADD FUNCTION.  
 * Reason:   TODO ADD REASON.  
 * Date:     2016年4月19日 下午4:12:23  
 * @author   wuwz 
 * @version   
 * @since    JDK 1.6 
 *        
 */
public class SftpTest {

	@Test
	public void testSftp() throws Exception {
		
		DownloadProcessor dl = new DownloadProcessor();
		StringBuffer response = new StringBuffer();
		TechImpl tech = new TechImpl();
		tech.getAttrMap().put(EndpointAttr.SFTP_PASSWORD, "abc@123");
		tech.getAttrMap().put(EndpointAttr.SFTP_SERVERIP, "10.1.234.61");
		tech.getAttrMap().put(EndpointAttr.SFTP_USERNAME, "root");
		tech.getAttrMap().put(EndpointAttr.SFTP_PORT, "22");
		tech.getAttrMap().put(EndpointAttr.TIMEOUT, "5500");

		Map<String,String> fileMap = new HashMap<String, String>();
		List<File> fileList = new ArrayList<File>();
		String fileDir = "/root/filetest";
		String fileTempDir = "d:/temp";
		dl.SftpTypeFileDownload(response, fileMap, fileList, null, 1000, EOPDomain.ORDERBY_LENGTH_DESC, tech, fileDir, null, fileTempDir,"Y");
		File[] fileArray = null;
		if(fileArray == null) {
			
			fileArray = (File[])fileList.toArray(new File[fileList.size()]);
		}
	}
}
