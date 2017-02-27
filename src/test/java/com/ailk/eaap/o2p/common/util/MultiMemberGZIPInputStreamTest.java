package com.ailk.eaap.o2p.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>MultiMemberGZIPInputStreamTest</code> contains tests for the class <code>{@link MultiMemberGZIPInputStream}</code>.
 *
 * @generatedBy CodePro at 15-12-10 上午9:05
 * @author windy
 * @version $Revision: 1.0 $
 */
public class MultiMemberGZIPInputStreamTest {
	/**
	 * Run the MultiMemberGZIPInputStream(InputStream) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.IOException.class)
	public void testMultiMemberGZIPInputStream_1()
		throws Exception {
		InputStream in = new PipedInputStream();

		MultiMemberGZIPInputStream result = new MultiMemberGZIPInputStream(in);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the MultiMemberGZIPInputStream(InputStream,int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.IOException.class)
	public void testMultiMemberGZIPInputStream_2()
		throws Exception {
		InputStream in = new PipedInputStream();
		int size = 1;

		MultiMemberGZIPInputStream result = new MultiMemberGZIPInputStream(in, size);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the int read(byte[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.IOException.class)
	public void testRead_3()
		throws Exception {
		MultiMemberGZIPInputStream fixture = new MultiMemberGZIPInputStream(new PipedInputStream(), 1);
		byte[] inputBuffer = new byte[] {};
		int inputBufferOffset = 1;
		int inputBufferLen = 1;

		int result = fixture.read(inputBuffer, inputBufferOffset, inputBufferLen);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int read(byte[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.IOException.class)
	public void testRead_4()
		throws Exception {
		MultiMemberGZIPInputStream fixture = new MultiMemberGZIPInputStream(new PipedInputStream(), 1);
		byte[] inputBuffer = new byte[] {};
		int inputBufferOffset = 1;
		int inputBufferLen = 1;

		int result = fixture.read(inputBuffer, inputBufferOffset, inputBufferLen);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int read(byte[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.IOException.class)
	public void testRead_5()
		throws Exception {
		MultiMemberGZIPInputStream fixture = new MultiMemberGZIPInputStream(new PipedInputStream(), 1);
		byte[] inputBuffer = new byte[] {};
		int inputBufferOffset = 1;
		int inputBufferLen = 1;

		int result = fixture.read(inputBuffer, inputBufferOffset, inputBufferLen);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int read(byte[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.IOException.class)
	public void testRead_6()
		throws Exception {
		MultiMemberGZIPInputStream fixture = new MultiMemberGZIPInputStream(new PipedInputStream(), 1);
		byte[] inputBuffer = new byte[] {};
		int inputBufferOffset = 1;
		int inputBufferLen = 1;

		int result = fixture.read(inputBuffer, inputBufferOffset, inputBufferLen);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int read(byte[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.IOException.class)
	public void testRead_7()
		throws Exception {
		MultiMemberGZIPInputStream fixture = new MultiMemberGZIPInputStream(new PipedInputStream(), 1);
		byte[] inputBuffer = new byte[] {};
		int inputBufferOffset = 1;
		int inputBufferLen = 1;

		int result = fixture.read(inputBuffer, inputBufferOffset, inputBufferLen);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int read(byte[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.IOException.class)
	public void testRead_8()
		throws Exception {
		MultiMemberGZIPInputStream fixture = new MultiMemberGZIPInputStream(new PipedInputStream(), 1);
		byte[] inputBuffer = new byte[] {};
		int inputBufferOffset = 1;
		int inputBufferLen = 1;

		int result = fixture.read(inputBuffer, inputBufferOffset, inputBufferLen);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int read(byte[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.IOException.class)
	public void testRead_9()
		throws Exception {
		MultiMemberGZIPInputStream fixture = new MultiMemberGZIPInputStream(new PipedInputStream(), 1);
		byte[] inputBuffer = new byte[] {};
		int inputBufferOffset = 1;
		int inputBufferLen = 1;

		int result = fixture.read(inputBuffer, inputBufferOffset, inputBufferLen);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int read(byte[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.IOException.class)
	public void testRead_10()
		throws Exception {
		MultiMemberGZIPInputStream fixture = new MultiMemberGZIPInputStream(new PipedInputStream(), 1);
		byte[] inputBuffer = new byte[] {};
		int inputBufferOffset = 1;
		int inputBufferLen = 1;

		int result = fixture.read(inputBuffer, inputBufferOffset, inputBufferLen);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int read(byte[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.IOException.class)
	public void testRead_11()
		throws Exception {
		MultiMemberGZIPInputStream fixture = new MultiMemberGZIPInputStream(new PipedInputStream(), 1);
		byte[] inputBuffer = new byte[] {};
		int inputBufferOffset = 1;
		int inputBufferLen = 1;

		int result = fixture.read(inputBuffer, inputBufferOffset, inputBufferLen);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int read(byte[],int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.IOException.class)
	public void testRead_12()
		throws Exception {
		MultiMemberGZIPInputStream fixture = new MultiMemberGZIPInputStream(new PipedInputStream(), 1);
		byte[] inputBuffer = new byte[] {};
		int inputBufferOffset = 1;
		int inputBufferLen = 1;

		int result = fixture.read(inputBuffer, inputBufferOffset, inputBufferLen);

		// add additional test code here
		assertEquals(0, result);
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
		new org.junit.runner.JUnitCore().run(MultiMemberGZIPInputStreamTest.class);
	}
}