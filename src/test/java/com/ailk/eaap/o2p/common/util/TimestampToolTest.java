package com.ailk.eaap.o2p.common.util;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TimestampToolTest</code> contains tests for the class <code>{@link TimestampTool}</code>.
 *
 * @generatedBy CodePro at 15-12-10 上午9:06
 * @author windy
 * @version $Revision: 1.0 $
 */
public class TimestampToolTest {
	/**
	 * Run the Date getDate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testGetDate_1()
		throws Exception {

		Date result = TimestampTool.getDate();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String getDate(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testGetDate_2()
		throws Exception {
		String format = "";

		String result = TimestampTool.getDate(format);

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getDate(long,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testGetDate_3()
		throws Exception {
		long time = 1L;
		String format = "";

		String result = TimestampTool.getDate(time, format);

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTimeStamp() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testGetTimeStamp_1()
		throws Exception {

		String result = TimestampTool.getTimeStamp();

	}

	/**
	 * Run the Calendar getUTCCalendar() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testGetUTCCalendar_1()
		throws Exception {

		Calendar result = TimestampTool.getUTCCalendar();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Date getUTCDate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testGetUTCDate_1()
		throws Exception {

		Date result = TimestampTool.getUTCDate();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String getUTCStr() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testGetUTCStr_1()
		throws Exception {

		String result = TimestampTool.getUTCStr();

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
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
	 * @generatedBy CodePro at 15-12-10 上午9:06
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
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TimestampToolTest.class);
	}
}