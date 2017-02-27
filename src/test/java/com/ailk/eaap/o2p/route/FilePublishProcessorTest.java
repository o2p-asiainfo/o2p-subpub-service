package com.ailk.eaap.o2p.route;

import org.junit.*;
import static org.junit.Assert.*;
import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.ailk.eaap.op2.bo.Endpoint;

/**
 * The class <code>FilePublishProcessorTest</code> contains tests for the class <code>{@link FilePublishProcessor}</code>.
 *
 * @generatedBy CodePro at 15-12-10 上午9:05
 * @author windy
 * @version $Revision: 1.0 $
 */
public class FilePublishProcessorTest {
	/**
	 * Run the FilePublishProcessor() constructor test.
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testFilePublishProcessor_1()
		throws Exception {
		FilePublishProcessor result = new FilePublishProcessor();
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
		FilePublishProcessor fixture = new FilePublishProcessor();

		fixture.clear();

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
		FilePublishProcessor fixture = new FilePublishProcessor();
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
		new org.junit.runner.JUnitCore().run(FilePublishProcessorTest.class);
	}
}