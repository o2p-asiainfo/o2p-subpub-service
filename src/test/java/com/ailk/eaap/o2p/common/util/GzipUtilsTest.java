package com.ailk.eaap.o2p.common.util;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.util.List;
import java.util.Vector;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>GzipUtilsTest</code> contains tests for the class <code>{@link GzipUtils}</code>.
 *
 * @generatedBy CodePro at 15-12-10 上午9:05
 * @author windy
 * @version $Revision: 1.0 $
 */
public class GzipUtilsTest {
	/**
	 * Run the GzipUtils() constructor test.
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testGzipUtils_1()
		throws Exception {
		GzipUtils result = new GzipUtils();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the List<File> compress(File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_1()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		File sourceFile = new File("");

		List<File> result = fixture.compress(sourceFile);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> compress(File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_2()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		File sourceFile = new File("");

		List<File> result = fixture.compress(sourceFile);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> compress(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_3()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		String sourceFilePath = "";

		List<File> result = fixture.compress(sourceFilePath);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> compress(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_4()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		String sourceFilePath = "";

		List<File> result = fixture.compress(sourceFilePath);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> compress(List<File>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testCompress_5()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		List<File> sourceFiles = new Vector();

		List<File> result = fixture.compress(sourceFiles);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> compress(List<File>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testCompress_6()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		List<File> sourceFiles = new Vector();

		List<File> result = fixture.compress(sourceFiles);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the byte[] compress(byte[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testCompress_7()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		byte[] bytes = new byte[] {};

		byte[] result = fixture.compress(bytes);

		// add additional test code here
		assertNotNull(result);
		assertEquals(20, result.length);
		assertEquals((byte) 31, result[0]);
		assertEquals((byte) -117, result[1]);
		assertEquals((byte) 8, result[2]);
		assertEquals((byte) 0, result[3]);
		assertEquals((byte) 0, result[4]);
		assertEquals((byte) 0, result[5]);
		assertEquals((byte) 0, result[6]);
		assertEquals((byte) 0, result[7]);
		assertEquals((byte) 0, result[8]);
	}

	/**
	 * Run the byte[] compress(byte[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testCompress_10()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		byte[] bytes = new byte[] {};

		byte[] result = fixture.compress(bytes);

		// add additional test code here
		assertNotNull(result);
		assertEquals(20, result.length);
		assertEquals((byte) 31, result[0]);
		assertEquals((byte) -117, result[1]);
		assertEquals((byte) 8, result[2]);
		assertEquals((byte) 0, result[3]);
		assertEquals((byte) 0, result[4]);
		assertEquals((byte) 0, result[5]);
		assertEquals((byte) 0, result[6]);
		assertEquals((byte) 0, result[7]);
		assertEquals((byte) 0, result[8]);
	}

	/**
	 * Run the List<File> compress(File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_11()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		File sourceFile = new File("");
		boolean delete = true;

		List<File> result = fixture.compress(sourceFile, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> compress(File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_12()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		File sourceFile = new File("");
		boolean delete = true;

		List<File> result = fixture.compress(sourceFile, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> compress(File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_13()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		File sourceFile = new File("");
		boolean delete = true;

		List<File> result = fixture.compress(sourceFile, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> compress(File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_14()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		File sourceFile = new File("");
		boolean delete = true;

		List<File> result = fixture.compress(sourceFile, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> compress(File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_15()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		File sourceFile = new File("");
		boolean delete = true;

		List<File> result = fixture.compress(sourceFile, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> compress(File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_16()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		File sourceFile = new File("");
		boolean delete = true;

		List<File> result = fixture.compress(sourceFile, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> compress(String,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_17()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		String sourceFilePath = "";
		boolean delete = true;

		List<File> result = fixture.compress(sourceFilePath, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> compress(String,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_18()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		String sourceFilePath = "";
		boolean delete = true;

		List<File> result = fixture.compress(sourceFilePath, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> compress(List<File>,Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testCompress_19()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		List<File> sourceFiles = null;
		Boolean delete = new Boolean(true);

		List<File> result = fixture.compress(sourceFiles, delete);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> compress(List<File>,Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testCompress_20()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		List<File> sourceFiles = new Vector();
		Boolean delete = new Boolean(true);

		List<File> result = fixture.compress(sourceFiles, delete);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> compress(List<File>,Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testCompress_21()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		List<File> sourceFiles = new Vector();
		Boolean delete = new Boolean(true);

		List<File> result = fixture.compress(sourceFiles, delete);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> compress(List<File>,Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testCompress_22()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		List<File> sourceFiles = new Vector();
		Boolean delete = new Boolean(true);

		List<File> result = fixture.compress(sourceFiles, delete);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> compress(List<File>,Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testCompress_23()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		List<File> sourceFiles = new Vector();
		Boolean delete = new Boolean(true);

		List<File> result = fixture.compress(sourceFiles, delete);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> compress(List<File>,Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testCompress_24()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		List<File> sourceFiles = new Vector();
		Boolean delete = new Boolean(true);

		List<File> result = fixture.compress(sourceFiles, delete);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> compress(List<File>,Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testCompress_25()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		List<File> sourceFiles = new Vector();
		Boolean delete = new Boolean(true);

		List<File> result = fixture.compress(sourceFiles, delete);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the void gdezip(InputStream,OutputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.IOException.class)
	public void testGdezip_1()
		throws Exception {
		InputStream fis = new PipedInputStream();
		OutputStream fos = new ByteArrayOutputStream();

		GzipUtils.gdezip(fis, fos);

		// add additional test code here
	}

	/**
	 * Run the void gdezip(InputStream,OutputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.IOException.class)
	public void testGdezip_2()
		throws Exception {
		InputStream fis = new PipedInputStream();
		OutputStream fos = new ByteArrayOutputStream();

		GzipUtils.gdezip(fis, fos);

		// add additional test code here
	}

	/**
	 * Run the void gdezip(InputStream,OutputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.IOException.class)
	public void testGdezip_3()
		throws Exception {
		InputStream fis = new PipedInputStream();
		OutputStream fos = new ByteArrayOutputStream();

		GzipUtils.gdezip(fis, fos);

		// add additional test code here
	}

	/**
	 * Run the void gdezip(InputStream,OutputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.IOException.class)
	public void testGdezip_4()
		throws Exception {
		InputStream fis = new PipedInputStream();
		OutputStream fos = new ByteArrayOutputStream();

		GzipUtils.gdezip(fis, fos);

		// add additional test code here
	}

	/**
	 * Run the void gdezip(InputStream,OutputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.IOException.class)
	public void testGdezip_5()
		throws Exception {
		InputStream fis = new PipedInputStream();
		OutputStream fos = new ByteArrayOutputStream();

		GzipUtils.gdezip(fis, fos);

		// add additional test code here
	}

	/**
	 * Run the void gdezip(InputStream,OutputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.IOException.class)
	public void testGdezip_6()
		throws Exception {
		InputStream fis = new PipedInputStream();
		OutputStream fos = new ByteArrayOutputStream();

		GzipUtils.gdezip(fis, fos);

		// add additional test code here
	}

	/**
	 * Run the void gdezip(InputStream,OutputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.IOException.class)
	public void testGdezip_7()
		throws Exception {
		InputStream fis = new PipedInputStream();
		OutputStream fos = new ByteArrayOutputStream();

		GzipUtils.gdezip(fis, fos);

		// add additional test code here
	}

	/**
	 * Run the void gdezip(InputStream,OutputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.IOException.class)
	public void testGdezip_8()
		throws Exception {
		InputStream fis = new PipedInputStream();
		OutputStream fos = new ByteArrayOutputStream();

		GzipUtils.gdezip(fis, fos);

		// add additional test code here
	}

	/**
	 * Run the void gdezip(InputStream,OutputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.IOException.class)
	public void testGdezip_9()
		throws Exception {
		InputStream fis = new PipedInputStream();
		OutputStream fos = new ByteArrayOutputStream();

		GzipUtils.gdezip(fis, fos);

		// add additional test code here
	}

	/**
	 * Run the void gdezip(InputStream,OutputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.IOException.class)
	public void testGdezip_10()
		throws Exception {
		InputStream fis = new PipedInputStream();
		OutputStream fos = new ByteArrayOutputStream();

		GzipUtils.gdezip(fis, fos);

		// add additional test code here
	}

	/**
	 * Run the void gdezip(InputStream,OutputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.IOException.class)
	public void testGdezip_11()
		throws Exception {
		InputStream fis = new PipedInputStream();
		OutputStream fos = new ByteArrayOutputStream();

		GzipUtils.gdezip(fis, fos);

		// add additional test code here
	}

	/**
	 * Run the List<File> uncompress(File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_1()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		File sourceFile = new File("");

		List<File> result = fixture.uncompress(sourceFile);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> uncompress(File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_2()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		File sourceFile = new File("");

		List<File> result = fixture.uncompress(sourceFile);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> uncompress(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_3()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		String sourceFilePath = "";

		List<File> result = fixture.uncompress(sourceFilePath);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> uncompress(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_4()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		String sourceFilePath = "";

		List<File> result = fixture.uncompress(sourceFilePath);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> uncompress(List<File>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testUncompress_5()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		List<File> sourceFiles = new Vector();

		List<File> result = fixture.uncompress(sourceFiles);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> uncompress(List<File>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testUncompress_6()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		List<File> sourceFiles = new Vector();

		List<File> result = fixture.uncompress(sourceFiles);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the byte[] uncompress(byte[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.EOFException.class)
	public void testUncompress_7()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		byte[] bytes = new byte[] {};

		byte[] result = fixture.uncompress(bytes);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the byte[] uncompress(byte[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.EOFException.class)
	public void testUncompress_8()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		byte[] bytes = new byte[] {};

		byte[] result = fixture.uncompress(bytes);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the byte[] uncompress(byte[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.EOFException.class)
	public void testUncompress_9()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		byte[] bytes = new byte[] {};

		byte[] result = fixture.uncompress(bytes);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the byte[] uncompress(byte[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = java.io.EOFException.class)
	public void testUncompress_10()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		byte[] bytes = new byte[] {};

		byte[] result = fixture.uncompress(bytes);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> uncompress(File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_11()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		File sourceFile = new File("");
		boolean delete = true;

		List<File> result = fixture.uncompress(sourceFile, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> uncompress(File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_12()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		File sourceFile = new File("");
		boolean delete = true;

		List<File> result = fixture.uncompress(sourceFile, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> uncompress(File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_13()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		File sourceFile = new File("");
		boolean delete = true;

		List<File> result = fixture.uncompress(sourceFile, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> uncompress(File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_14()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		File sourceFile = new File("");
		boolean delete = true;

		List<File> result = fixture.uncompress(sourceFile, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> uncompress(File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_15()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		File sourceFile = new File("");
		boolean delete = true;

		List<File> result = fixture.uncompress(sourceFile, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> uncompress(File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_16()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		File sourceFile = new File("");
		boolean delete = true;

		List<File> result = fixture.uncompress(sourceFile, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> uncompress(String,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_17()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		String sourceFilePath = "";
		boolean delete = true;

		List<File> result = fixture.uncompress(sourceFilePath, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> uncompress(String,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_18()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		String sourceFilePath = "";
		boolean delete = true;

		List<File> result = fixture.uncompress(sourceFilePath, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> uncompress(List<File>,Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testUncompress_19()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		List<File> sourceFiles = null;
		Boolean delete = new Boolean(true);

		List<File> result = fixture.uncompress(sourceFiles, delete);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> uncompress(List<File>,Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testUncompress_20()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		List<File> sourceFiles = new Vector();
		Boolean delete = new Boolean(true);

		List<File> result = fixture.uncompress(sourceFiles, delete);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> uncompress(List<File>,Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testUncompress_21()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		List<File> sourceFiles = new Vector();
		Boolean delete = new Boolean(true);

		List<File> result = fixture.uncompress(sourceFiles, delete);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> uncompress(List<File>,Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testUncompress_22()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		List<File> sourceFiles = new Vector();
		Boolean delete = new Boolean(true);

		List<File> result = fixture.uncompress(sourceFiles, delete);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> uncompress(List<File>,Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testUncompress_23()
		throws Exception {
		GzipUtils fixture = new GzipUtils();
		List<File> sourceFiles = new Vector();
		Boolean delete = new Boolean(true);

		List<File> result = fixture.uncompress(sourceFiles, delete);

		// add additional test code here
		assertEquals(null, result);
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
		new org.junit.runner.JUnitCore().run(GzipUtilsTest.class);
	}
}