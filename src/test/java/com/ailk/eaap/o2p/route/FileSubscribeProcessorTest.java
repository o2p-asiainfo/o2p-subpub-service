package com.ailk.eaap.o2p.route;

import java.util.HashMap;
import java.util.Map;
import org.junit.*;
import static org.junit.Assert.*;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.Endpoint;

/**
 * The class <code>FileSubscribeProcessorTest</code> contains tests for the class <code>{@link FileSubscribeProcessor}</code>.
 *
 * @generatedBy CodePro at 15-12-10 上午9:07
 * @author windy
 * @version $Revision: 1.0 $
 */
public class FileSubscribeProcessorTest {
	/**
	 * Run the FileSubscribeProcessor() constructor test.
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testFileSubscribeProcessor_1()
		throws Exception {
		FileSubscribeProcessor result = new FileSubscribeProcessor();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the void clear() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testClear_1()
		throws Exception {
		FileSubscribeProcessor fixture = new FileSubscribeProcessor();

		fixture.clear();

		// add additional test code here
	}

	

	/**
	 * Run the void subtraThreadNum(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testSubtraThreadNum_1()
		throws Exception {
		FileSubscribeProcessor fixture = new FileSubscribeProcessor();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(FileSubscribeProcessorTest.class);
	}
}