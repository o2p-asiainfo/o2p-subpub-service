package com.ailk.eaap.o2p.route;

import java.util.HashMap;
import java.util.Map;

import org.junit.*;

import static org.junit.Assert.*;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.foundation.exception.BusinessException;
import com.ailk.eaap.op2.bo.Endpoint;
import com.ailk.eaap.op2.bo.SerInvokeIns;
import com.asiainfo.integretion.o2p.serviceagent.cache.CacheServiceImpl;
import com.asiainfo.integretion.o2p.serviceagent.cache.IMemcacheManageServ;

/**
 * The class <code>DownloadProcessorTest</code> contains tests for the class <code>{@link DownloadProcessor}</code>.
 *
 * @generatedBy CodePro at 15-12-10 涓婂崍9:05
 * @author windy
 * @version $Revision: 1.0 $
 */
public class DownloadProcessorTest {
	/**
	 * Run the DownloadProcessor() constructor test.
	 *
	 * @generatedBy CodePro at 15-12-10 涓婂崍9:05
	 */
	@Test
	public void testDownloadProcessor_1()
		throws Exception {
		DownloadProcessor result = new DownloadProcessor();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the void clear() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 涓婂崍9:05
	 */
	@Test
	public void testClear_1()
		throws Exception {
		DownloadProcessor fixture = new DownloadProcessor();
		fixture.setDownloadTempDir("");
		fixture.setCacheService(new CacheServiceImpl());

		fixture.clear();

		// add additional test code here
	}

	/**
	 * Run the IMemcacheManageServ getCacheService() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 涓婂崍9:05
	 */
	@Test
	public void testGetCacheService_1()
		throws Exception {
		DownloadProcessor fixture = new DownloadProcessor();
		fixture.setDownloadTempDir("");
		fixture.setCacheService(new CacheServiceImpl());

		IMemcacheManageServ result = fixture.getCacheService();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getRunTimeMemcachedClient());
	}

	/**
	 * Run the String getDownloadTempDir() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 涓婂崍9:05
	 */
	@Test
	public void testGetDownloadTempDir_1()
		throws Exception {
		DownloadProcessor fixture = new DownloadProcessor();
		fixture.setDownloadTempDir("");
		fixture.setCacheService(new CacheServiceImpl());

		String result = fixture.getDownloadTempDir();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the MessageBO process(Endpoint,MessageBO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 涓婂崍9:05
	 */
	@Test(expected=BusinessException.class)
	public void testProcess_1()
		throws Exception {
		DownloadProcessor fixture = new DownloadProcessor();
		fixture.setDownloadTempDir("");
		fixture.setCacheService(new CacheServiceImpl());
		Endpoint endpoint = new Endpoint();
		endpoint.setEndpointId(1);
		endpoint.setAttrMap(new HashMap<String, Object>());
		MessageBO msg = new MessageBO();
		msg.setSerInvokeIns(new SerInvokeIns());

		MessageBO result = fixture.process(endpoint, msg);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.ailk.eaap.o2p.route.DownloadProcessor.endpointValue(DownloadProcessor.java:515)
		//       at com.ailk.eaap.o2p.route.DownloadProcessor.process(DownloadProcessor.java:99)
		assertNotNull(result);
	}

	/**
	 * Run the MessageBO process(Endpoint,MessageBO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 涓婂崍9:05
	 */
	@Test(expected=NullPointerException.class)
	public void testProcess_2()
		throws Exception {
		DownloadProcessor fixture = new DownloadProcessor();
		fixture.setDownloadTempDir("");
		fixture.setCacheService(new CacheServiceImpl());
		Endpoint endpoint = new Endpoint();
		endpoint.setEndpointId(1);
		endpoint.setAttrMap(new HashMap());
		MessageBO msg = new MessageBO();

		MessageBO result = fixture.process(endpoint, msg);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    <exception><code>9556</code><msg>鏂囦欢鐩綍涓嶆槸鏈夋晥鍊�fileDir=</msg><exceptionTrace>com.asiainfo.foundation.exception.BusinessException
		//       at com.ailk.eaap.o2p.route.DownloadProcessor.endpointValue(DownloadProcessor.java:536)
		//       at com.ailk.eaap.o2p.route.DownloadProcessor.process(DownloadProcessor.java:99)
		assertNotNull(result);
	}

	/**
	 * Run the void setCacheService(IMemcacheManageServ) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 涓婂崍9:05
	 */
	@Test
	public void testSetCacheService_1()
		throws Exception {
		DownloadProcessor fixture = new DownloadProcessor();
		fixture.setDownloadTempDir("");
		fixture.setCacheService(new CacheServiceImpl());
		IMemcacheManageServ cacheService = new CacheServiceImpl();

		fixture.setCacheService(cacheService);

		// add additional test code here
	}

	/**
	 * Run the void setDownloadTempDir(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 涓婂崍9:05
	 */
	@Test
	public void testSetDownloadTempDir_1()
		throws Exception {
		DownloadProcessor fixture = new DownloadProcessor();
		fixture.setDownloadTempDir("");
		fixture.setCacheService(new CacheServiceImpl());
		String downloadTempDir = "";

		fixture.setDownloadTempDir(downloadTempDir);

		// add additional test code here
	}

	/**
	 * Run the void subtraThreadNum(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 涓婂崍9:05
	 */
	@Test
	public void testSubtraThreadNum_1()
		throws Exception {
		DownloadProcessor fixture = new DownloadProcessor();
		fixture.setDownloadTempDir("");
		fixture.setCacheService(new CacheServiceImpl());
		String servId = "";

		fixture.subtraThreadNum(servId);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15-12-10 涓婂崍9:05
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 15-12-10 涓婂崍9:05
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 15-12-10 涓婂崍9:05
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(DownloadProcessorTest.class);
	}
}