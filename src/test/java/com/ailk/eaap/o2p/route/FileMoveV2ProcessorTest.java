package com.ailk.eaap.o2p.route;

import java.util.HashMap;
import java.util.Map;

import org.easymock.EasyMock;
import org.junit.*;

import static org.junit.Assert.*;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.Endpoint;
import com.asiainfo.integretion.o2p.serviceagent.cache.CacheServiceImpl;
import com.asiainfo.integretion.o2p.serviceagent.cache.IMemcacheManageServ;

/**
 * The class <code>FileMoveV2ProcessorTest</code> contains tests for the class <code>{@link FileMoveV2Processor}</code>.
 *
 * @generatedBy CodePro at 15-12-10 上午9:05
 * @author windy
 * @version $Revision: 1.0 $
 */
public class FileMoveV2ProcessorTest {
	
	
	
	@Test
	public void testFileMoveV2Processor_2()
		throws Exception {
		FileMoveV2Processor result = EasyMock.createMock(FileMoveV2Processor.class);
		assertNotNull(result);
		// add additional test code here
	}
	
	/**
	 * Run the FileMoveV2Processor() constructor test.
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testFileMoveV2Processor_1()
		throws Exception {
		FileMoveV2Processor result = new FileMoveV2Processor();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the void clear() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testClear_1()
		throws Exception {
		FileMoveV2Processor fixture = new FileMoveV2Processor();
		fixture.setCacheService(new CacheServiceImpl());
		fixture.setBackupTempDir("");

		fixture.clear();

		// add additional test code here
	}

	

	/**
	 * Run the String getBackupTempDir() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testGetBackupTempDir_1()
		throws Exception {
		FileMoveV2Processor fixture = new FileMoveV2Processor();
		fixture.setCacheService(new CacheServiceImpl());
		fixture.setBackupTempDir("");

		String result = fixture.getBackupTempDir();

		// add additional test code here
		assertEquals("", result);
	}
	

	

	/**
	 * Run the void setBackupTempDir(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testSetBackupTempDir_1()
		throws Exception {
		FileMoveV2Processor fixture = new FileMoveV2Processor();
		fixture.setCacheService(new CacheServiceImpl());
		fixture.setBackupTempDir("");
		String backupTempDir = "";

		fixture.setBackupTempDir(backupTempDir);

		// add additional test code here
	}

	/**
	 * Run the void setCacheService(IMemcacheManageServ) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testSetCacheService_1()
		throws Exception {
		FileMoveV2Processor fixture = new FileMoveV2Processor();
		fixture.setCacheService(new CacheServiceImpl());
		fixture.setBackupTempDir("");
		IMemcacheManageServ cacheService = new CacheServiceImpl();

		fixture.setCacheService(cacheService);

		// add additional test code here
	}

	/**
	 * Run the void subtraThreadNum(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testSubtraThreadNum_1()
		throws Exception {
		FileMoveV2Processor fixture = new FileMoveV2Processor();
		fixture.setCacheService(new CacheServiceImpl());
		fixture.setBackupTempDir("");
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
	 * @generatedBy CodePro at 15-12-10 上午9:05
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
	 * @generatedBy CodePro at 15-12-10 上午9:05
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
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(FileMoveV2ProcessorTest.class);
	}
	
	@Test
	public void testFileExpr_1()
		throws Exception {
		FileMoveV2Processor fixture = new FileMoveV2Processor();
		fixture.setBackupTempDir("");
		fixture.setCacheService(new CacheServiceImpl());
		String filename = "aa";
		String suffix = "a";
		String expression = "a";

		String result = fixture.fileExpr(filename, suffix, expression);

		// add additional test code here
		assertEquals(".a", result);
	}

	/**
	 * Run the String fileExpr(String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-21 下午2:43
	 */
	@Test
	public void testFileExpr_2()
		throws Exception {
		FileMoveV2Processor fixture = new FileMoveV2Processor();
		fixture.setBackupTempDir("");
		fixture.setCacheService(new CacheServiceImpl());
		String filename = "a";
		String suffix = "";
		String expression = "a";

		String result = fixture.fileExpr(filename, suffix, expression);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: 无法转化空的表达式
		//       at org.wltea.expression.ExpressionExecutor.compile(ExpressionExecutor.java:61)
		//       at org.wltea.expression.ExpressionEvaluator.evaluate(ExpressionEvaluator.java:137)
		//       at com.ailk.eaap.o2p.route.FileMoveV2Processor.fileExpr(FileMoveV2Processor.java:534)
		assertNotNull(result);
	}

	/**
	 * Run the String fileExpr(String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-21 下午2:43
	 */
	@Test
	public void testFileExpr_3()
		throws Exception {
		FileMoveV2Processor fixture = new FileMoveV2Processor();
		fixture.setBackupTempDir("");
		fixture.setCacheService(new CacheServiceImpl());
		String filename = "a";
		String suffix = "a";
		String expression = "a";

		String result = fixture.fileExpr(filename, suffix, expression);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: 无法转化空的表达式
		//       at org.wltea.expression.ExpressionExecutor.compile(ExpressionExecutor.java:61)
		//       at org.wltea.expression.ExpressionEvaluator.evaluate(ExpressionEvaluator.java:137)
		//       at com.ailk.eaap.o2p.route.FileMoveV2Processor.fileExpr(FileMoveV2Processor.java:534)
		assertNotNull(result);
	}

}