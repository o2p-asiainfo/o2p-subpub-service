package com.ailk.eaap.o2p.common.util;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>CompressExceptionTest</code> contains tests for the class <code>{@link CompressException}</code>.
 *
 * @generatedBy CodePro at 15-12-10 上午9:07
 * @author windy
 * @version $Revision: 1.0 $
 */
public class CompressExceptionTest {
	/**
	 * Run the CompressException(String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testCompressException_1()
		throws Exception {
		String detail = "";

		CompressException result = new CompressException(detail);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getCause());
		assertEquals("com.ailk.eaap.o2p.common.util.CompressException: ", result.toString());
		assertEquals("", result.getLocalizedMessage());
		assertEquals("", result.getMessage());
	}

	/**
	 * Run the CompressException(String,Exception) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testCompressException_2()
		throws Exception {
		String detail = "";
		Exception e = new Exception();

		CompressException result = new CompressException(detail, e);

		// add additional test code here
		assertNotNull(result);
		assertEquals("com.ailk.eaap.o2p.common.util.CompressException: ", result.toString());
		assertEquals("", result.getLocalizedMessage());
		assertEquals("", result.getMessage());
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
		new org.junit.runner.JUnitCore().run(CompressExceptionTest.class);
	}
}