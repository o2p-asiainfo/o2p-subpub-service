package com.ailk.eaap.o2p.common.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>Bzip2UtilsTest</code> contains tests for the class <code>{@link Bzip2Utils}</code>.
 *
 * @generatedBy CodePro at 15-12-10 上午9:07
 * @author windy
 * @version $Revision: 1.0 $
 */
public class Bzip2UtilsTest {
	/**
	 * Run the Bzip2Utils() constructor test.
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testBzip2Utils_1()
		throws Exception {
		Bzip2Utils result = new Bzip2Utils();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the File bdezip(File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testBdezip_1()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
		File file = null;
		boolean delete = true;

		File result = fixture.bdezip(file, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the File bdezip(File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testBdezip_2()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
		File file = new File("");
		boolean delete = true;

		File result = fixture.bdezip(file, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the File bdezip(File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testBdezip_3()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
		File file = new File("");
		boolean delete = true;

		File result = fixture.bdezip(file, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the File bdezip(File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testBdezip_4()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
		File file = new File("");
		boolean delete = true;

		File result = fixture.bdezip(file, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the File bdezip(File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testBdezip_5()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
		File file = new File("");
		boolean delete = true;

		File result = fixture.bdezip(file, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the File bdezip(File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testBdezip_6()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
		File file = new File("");
		boolean delete = true;

		File result = fixture.bdezip(file, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the File bdezip(File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testBdezip_7()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
		File file = new File("");
		boolean delete = true;

		File result = fixture.bdezip(file, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the File bdezip(File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testBdezip_8()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
		File file = new File("");
		boolean delete = true;

		File result = fixture.bdezip(file, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the File bdezip(File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testBdezip_9()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
		File file = new File("");
		boolean delete = true;

		File result = fixture.bdezip(file, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the File bdezip(File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testBdezip_10()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
		File file = new File("");
		boolean delete = false;

		File result = fixture.bdezip(file, delete);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<File> compress(File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_1()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_2()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_3()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_4()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testCompress_5()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testCompress_6()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testCompress_7()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
		byte[] bytes = new byte[] {};

		byte[] result = fixture.compress(bytes);

		// add additional test code here
		assertNotNull(result);
		assertEquals(14, result.length);
		assertEquals((byte) 66, result[0]);
		assertEquals((byte) 90, result[1]);
		assertEquals((byte) 104, result[2]);
		assertEquals((byte) 57, result[3]);
		assertEquals((byte) 23, result[4]);
		assertEquals((byte) 114, result[5]);
		assertEquals((byte) 69, result[6]);
		assertEquals((byte) 56, result[7]);
		assertEquals((byte) 80, result[8]);
		assertEquals((byte) -112, result[9]);
		assertEquals((byte) 0, result[10]);
		assertEquals((byte) 0, result[11]);
		assertEquals((byte) 0, result[12]);
		assertEquals((byte) 0, result[13]);
	}

	/**
	 * Run the byte[] compress(byte[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testCompress_8()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
		byte[] bytes = new byte[] {};

		byte[] result = fixture.compress(bytes);

		// add additional test code here
		assertNotNull(result);
		assertEquals(14, result.length);
		assertEquals((byte) 66, result[0]);
		assertEquals((byte) 90, result[1]);
		assertEquals((byte) 104, result[2]);
		assertEquals((byte) 57, result[3]);
		assertEquals((byte) 23, result[4]);
		assertEquals((byte) 114, result[5]);
		assertEquals((byte) 69, result[6]);
		assertEquals((byte) 56, result[7]);
		assertEquals((byte) 80, result[8]);
		assertEquals((byte) -112, result[9]);
		assertEquals((byte) 0, result[10]);
		assertEquals((byte) 0, result[11]);
		assertEquals((byte) 0, result[12]);
		assertEquals((byte) 0, result[13]);
	}

	/**
	 * Run the byte[] compress(byte[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testCompress_9()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
		byte[] bytes = new byte[] {};

		byte[] result = fixture.compress(bytes);

		// add additional test code here
		assertNotNull(result);
		assertEquals(14, result.length);
		assertEquals((byte) 66, result[0]);
		assertEquals((byte) 90, result[1]);
		assertEquals((byte) 104, result[2]);
		assertEquals((byte) 57, result[3]);
		assertEquals((byte) 23, result[4]);
		assertEquals((byte) 114, result[5]);
		assertEquals((byte) 69, result[6]);
		assertEquals((byte) 56, result[7]);
		assertEquals((byte) 80, result[8]);
		assertEquals((byte) -112, result[9]);
		assertEquals((byte) 0, result[10]);
		assertEquals((byte) 0, result[11]);
		assertEquals((byte) 0, result[12]);
		assertEquals((byte) 0, result[13]);
	}

	/**
	 * Run the byte[] compress(byte[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testCompress_10()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
		byte[] bytes = new byte[] {};

		byte[] result = fixture.compress(bytes);

		// add additional test code here
		assertNotNull(result);
		assertEquals(14, result.length);
		assertEquals((byte) 66, result[0]);
		assertEquals((byte) 90, result[1]);
		assertEquals((byte) 104, result[2]);
		assertEquals((byte) 57, result[3]);
		assertEquals((byte) 23, result[4]);
		assertEquals((byte) 114, result[5]);
		assertEquals((byte) 69, result[6]);
		assertEquals((byte) 56, result[7]);
		assertEquals((byte) 80, result[8]);
		assertEquals((byte) -112, result[9]);
		assertEquals((byte) 0, result[10]);
		assertEquals((byte) 0, result[11]);
		assertEquals((byte) 0, result[12]);
		assertEquals((byte) 0, result[13]);
	}

	/**
	 * Run the List<File> compress(File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_11()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_12()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_13()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_14()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_15()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_16()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_17()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testCompress_18()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testCompress_19()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testCompress_20()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testCompress_21()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testCompress_22()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testCompress_23()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
		List<File> sourceFiles = new Vector();
		Boolean delete = new Boolean(true);

		List<File> result = fixture.compress(sourceFiles, delete);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> uncompress(File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_1()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_2()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_3()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_4()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testUncompress_5()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testUncompress_6()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = java.io.IOException.class)
	public void testUncompress_7()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = java.io.IOException.class)
	public void testUncompress_8()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = java.io.IOException.class)
	public void testUncompress_9()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = java.io.IOException.class)
	public void testUncompress_10()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_11()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_12()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_13()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_14()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_15()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_16()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_17()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test(expected = com.ailk.eaap.o2p.common.util.CompressException.class)
	public void testUncompress_18()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testUncompress_19()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testUncompress_20()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testUncompress_21()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testUncompress_22()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	@Test
	public void testUncompress_23()
		throws Exception {
		Bzip2Utils fixture = new Bzip2Utils();
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
		new org.junit.runner.JUnitCore().run(Bzip2UtilsTest.class);
	}
}