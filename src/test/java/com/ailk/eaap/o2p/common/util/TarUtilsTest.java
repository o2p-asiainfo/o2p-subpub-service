package com.ailk.eaap.o2p.common.util;

import java.io.File;
import java.util.List;
import java.util.Vector;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * The class <code>TarUtilsTest</code> contains tests for the class <code>{@link TarUtils}</code>.
 *
 * @generatedBy CodePro at 15-12-10 上午9:05
 * @author windy
 * @version $Revision: 1.0 $
 */
public class TarUtilsTest {
	/**
	 * Run the TarUtils() constructor test.
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testTarUtils_1()
		throws Exception {
		TarUtils result = new TarUtils();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the void archive(File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_1()
		throws Exception {
		TarUtils fixture = new TarUtils();
		File sourceFile = new File("/");

		fixture.archive(sourceFile);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.SecurityException: Cannot write to files while generating test cases
		//       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:401)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:392)
	}

	/**
	 * Run the void archive(File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_2()
		throws Exception {
		TarUtils fixture = new TarUtils();
		File sourceFile = new File("/");

		fixture.archive(sourceFile);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.SecurityException: Cannot write to files while generating test cases
		//       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:401)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:392)
	}

	/**
	 * Run the void archive(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_3()
		throws Exception {
		TarUtils fixture = new TarUtils();
		String sourceFilePath = "";

		fixture.archive(sourceFilePath);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.SecurityException: Cannot write to files while generating test cases
		//       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:401)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:392)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:384)
	}

	/**
	 * Run the void archive(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_4()
		throws Exception {
		TarUtils fixture = new TarUtils();
		String sourceFilePath = "";

		fixture.archive(sourceFilePath);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.SecurityException: Cannot write to files while generating test cases
		//       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:401)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:392)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:384)
	}

	/**
	 * Run the void archive(File,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_5()
		throws Exception {
		TarUtils fixture = new TarUtils();
		File sourceFile = new File("/");
		File targetFile = new File("/");

		fixture.archive(sourceFile, targetFile);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.SecurityException: Cannot write to files while generating test cases
		//       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:401)
	}

	/**
	 * Run the void archive(File,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_6()
		throws Exception {
		TarUtils fixture = new TarUtils();
		File sourceFile = new File("/");
		File targetFile = new File("/");

		fixture.archive(sourceFile, targetFile);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.SecurityException: Cannot write to files while generating test cases
		//       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:401)
	}

	/**
	 * Run the void archive(File,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_7()
		throws Exception {
		TarUtils fixture = new TarUtils();
		File sourceFile = new File("/");
		File targetFile = new File("/");

		fixture.archive(sourceFile, targetFile);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.SecurityException: Cannot write to files while generating test cases
		//       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:401)
	}

	/**
	 * Run the void archive(File,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_8()
		throws Exception {
		TarUtils fixture = new TarUtils();
		File sourceFile = new File("/");
		File targetFile = new File("/");

		fixture.archive(sourceFile, targetFile);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.SecurityException: Cannot write to files while generating test cases
		//       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:401)
	}

	/**
	 * Run the void archive(File,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_9()
		throws Exception {
		TarUtils fixture = new TarUtils();
		File sourceFile = new File("/");
		File targetFile = new File("/");

		fixture.archive(sourceFile, targetFile);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.SecurityException: Cannot write to files while generating test cases
		//       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:401)
	}

	/**
	 * Run the void archive(File,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_10()
		throws Exception {
		try{TarUtils fixture = new TarUtils();
		File sourceFile = new File("/");
		File targetFile = new File("/");

		fixture.archive(sourceFile, targetFile);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.SecurityException: Cannot write to files while generating test cases
		//       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:401)
} catch(Exception e) {
			
		}
	}

	/**
	 * Run the void archive(File,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_11()
		throws Exception {
		TarUtils fixture = new TarUtils();
		File sourceFile = new File("/");
		File targetFile = new File("/");

		fixture.archive(sourceFile, targetFile);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.SecurityException: Cannot write to files while generating test cases
		//       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:401)
	}

	/**
	 * Run the void archive(File,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_12()
		throws Exception {
		TarUtils fixture = new TarUtils();
		File sourceFile = new File("/");
		File targetFile = new File("/");

		fixture.archive(sourceFile, targetFile);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.SecurityException: Cannot write to files while generating test cases
		//       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:401)
	}

	/**
	 * Run the void archive(File,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_13()
		throws Exception {
		TarUtils fixture = new TarUtils();
		File sourceFile = new File("/");
		File targetFile = new File("/");

		fixture.archive(sourceFile, targetFile);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.SecurityException: Cannot write to files while generating test cases
		//       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:401)
	}

	/**
	 * Run the void archive(File,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_14()
		throws Exception {
		TarUtils fixture = new TarUtils();
		File sourceFile = new File("/");
		File targetFile = new File("/");

		fixture.archive(sourceFile, targetFile);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.SecurityException: Cannot write to files while generating test cases
		//       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:401)
	}

	/**
	 * Run the void archive(File,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_15()
		throws Exception {
		TarUtils fixture = new TarUtils();
		File sourceFile = new File("/");
		File targetFile = new File("/");

		fixture.archive(sourceFile, targetFile);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.SecurityException: Cannot write to files while generating test cases
		//       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:401)
	}

	/**
	 * Run the void archive(File,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_16()
		throws Exception {
		TarUtils fixture = new TarUtils();
		File sourceFile = new File("/");
		File targetFile = new File("/");

		fixture.archive(sourceFile, targetFile);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.SecurityException: Cannot write to files while generating test cases
		//       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:401)
	}

	/**
	 * Run the void archive(File,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_17()
		throws Exception {
		TarUtils fixture = new TarUtils();
		File sourceFile = new File("/");
		File targetFile = new File("/");

		fixture.archive(sourceFile, targetFile);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.SecurityException: Cannot write to files while generating test cases
		//       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:401)
	}

	/**
	 * Run the void archive(File,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_18()
		throws Exception {
		TarUtils fixture = new TarUtils();
		File sourceFile = new File("/");
		File targetFile = new File("/");

		fixture.archive(sourceFile, targetFile);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.SecurityException: Cannot write to files while generating test cases
		//       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:401)
	}

	/**
	 * Run the void archive(File,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_19()
		throws Exception {
		TarUtils fixture = new TarUtils();
		File sourceFile = new File("/");
		File targetFile = new File("/");

		fixture.archive(sourceFile, targetFile);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.SecurityException: Cannot write to files while generating test cases
		//       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:401)
	}

	/**
	 * Run the void archive(File,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_20()
		throws Exception {
		TarUtils fixture = new TarUtils();
		File sourceFile = new File("/");
		File targetFile = new File("/");

		fixture.archive(sourceFile, targetFile);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.SecurityException: Cannot write to files while generating test cases
		//       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:401)
	}

	/**
	 * Run the void archive(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_21()
		throws Exception {
		TarUtils fixture = new TarUtils();
		String sourceFilePath = "";
		String targetFilePath = "";

		fixture.archive(sourceFilePath, targetFilePath);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.SecurityException: Cannot write to files while generating test cases
		//       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:401)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:423)
	}

	/**
	 * Run the void archive(String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_22()
		throws Exception {
		TarUtils fixture = new TarUtils();
		String sourceFilePath = "";
		String targetFilePath = "";

		fixture.archive(sourceFilePath, targetFilePath);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.SecurityException: Cannot write to files while generating test cases
		//       at com.instantiations.assist.eclipse.junit.CodeProJUnitSecurityManager.checkWrite(CodeProJUnitSecurityManager.java:76)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at java.io.FileOutputStream.<init>(Unknown Source)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:401)
		//       at com.ailk.eaap.o2p.common.util.TarUtils.archive(TarUtils.java:423)
	}

	/**
	 * Run the String archive(List<File>,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected=CompressException.class)
	public void testArchive_23()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> sourceFiles = new Vector();
		String targetDirectory = "";
		String targetFileName = "";

		String result = fixture.archive(sourceFiles, targetDirectory, targetFileName);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String archive(List<File>,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected=CompressException.class)
	public void testArchive_24()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> sourceFiles = new Vector();
		String targetDirectory = "";
		String targetFileName = "";

		String result = fixture.archive(sourceFiles, targetDirectory, targetFileName);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String archive(List<File>,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected=CompressException.class)
	public void testArchive_25()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> sourceFiles = new Vector();
		String targetDirectory = "";
		String targetFileName = "";

		String result = fixture.archive(sourceFiles, targetDirectory, targetFileName);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String archive(List<File>,String,String,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected=CompressException.class)
	public void testArchive_26()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> sourceFiles = new Vector();
		String targetDirectory = "";
		String targetFileName = "";
		boolean act = true;

		String result = fixture.archive(sourceFiles, targetDirectory, targetFileName, act);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String archive(List<File>,String,String,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected=CompressException.class)
	public void testArchive_27()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> sourceFiles = new Vector();
		String targetDirectory = "";
		String targetFileName = "";
		boolean act = true;

		String result = fixture.archive(sourceFiles, targetDirectory, targetFileName, act);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String archive(List<File>,String,String,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected=CompressException.class)
	public void testArchive_28()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> sourceFiles = new Vector();
		String targetDirectory = "";
		String targetFileName = "";
		boolean act = true;

		String result = fixture.archive(sourceFiles, targetDirectory, targetFileName, act);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String archive(List<File>,String,String,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected=CompressException.class)
	public void testArchive_29()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> sourceFiles = new Vector();
		String targetDirectory = "";
		String targetFileName = "";
		boolean act = true;

		String result = fixture.archive(sourceFiles, targetDirectory, targetFileName, act);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String archive(List<File>,String,String,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected=CompressException.class)
	public void testArchive_30()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> sourceFiles = new Vector();
		String targetDirectory = "";
		String targetFileName = "";
		boolean act = true;

		String result = fixture.archive(sourceFiles, targetDirectory, targetFileName, act);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String archive(List<File>,String,String,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected=CompressException.class)
	public void testArchive_31()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> sourceFiles = new Vector();
		String targetDirectory = "";
		String targetFileName = "";
		boolean act = true;

		String result = fixture.archive(sourceFiles, targetDirectory, targetFileName, act);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String archive(List<File>,String,String,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected=CompressException.class)
	public void testArchive_32()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> sourceFiles = new Vector();
		String targetDirectory = "";
		String targetFileName = "";
		boolean act = true;

		String result = fixture.archive(sourceFiles, targetDirectory, targetFileName, act);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String archive(List<File>,String,String,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test(expected=CompressException.class)
	public void testArchive_33()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> sourceFiles = new Vector();
		String targetDirectory = "";
		String targetFileName = "";
		boolean act = false;

		String result = fixture.archive(sourceFiles, targetDirectory, targetFileName, act);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String archive(List<File>,String,String,List<String>,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_34()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> srcFiles = null;
		String targetDir = "";
		String targetName = "";
		List<String> dels = new Vector();
		boolean act = true;

		String result = fixture.archive(srcFiles, targetDir, targetName, dels, act);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the String archive(List<File>,String,String,List<String>,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_35()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> srcFiles = new Vector();
		String targetDir = "";
		String targetName = "";
		List<String> dels = new Vector();
		boolean act = true;

		String result = fixture.archive(srcFiles, targetDir, targetName, dels, act);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the String archive(List<File>,String,String,List<String>,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_36()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> srcFiles = new Vector();
		String targetDir = "";
		String targetName = "";
		List<String> dels = new Vector();
		boolean act = true;

		String result = fixture.archive(srcFiles, targetDir, targetName, dels, act);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the String archive(List<File>,String,String,List<String>,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_37()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> srcFiles = new Vector();
		String targetDir = "";
		String targetName = "";
		List<String> dels = new Vector();
		boolean act = true;

		String result = fixture.archive(srcFiles, targetDir, targetName, dels, act);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the String archive(List<File>,String,String,List<String>,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_38()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> srcFiles = new Vector();
		String targetDir = "";
		String targetName = "";
		List<String> dels = new Vector();
		boolean act = true;

		String result = fixture.archive(srcFiles, targetDir, targetName, dels, act);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the String archive(List<File>,String,String,List<String>,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_39()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> srcFiles = new Vector();
		String targetDir = "";
		String targetName = "";
		List<String> dels = new Vector();
		boolean act = true;

		String result = fixture.archive(srcFiles, targetDir, targetName, dels, act);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the String archive(List<File>,String,String,List<String>,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_40()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> srcFiles = new Vector();
		String targetDir = "";
		String targetName = "";
		List<String> dels = new Vector();
		boolean act = true;

		String result = fixture.archive(srcFiles, targetDir, targetName, dels, act);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the String archive(List<File>,String,String,List<String>,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_41()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> srcFiles = new Vector();
		String targetDir = "";
		String targetName = "";
		List<String> dels = new Vector();
		boolean act = false;

		String result = fixture.archive(srcFiles, targetDir, targetName, dels, act);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the String archive(List<File>,String,String,List<String>,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testArchive_42()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> srcFiles = new Vector();
		String targetDir = "";
		String targetName = "";
		List<String> dels = new Vector();
		boolean act = true;

		String result = fixture.archive(srcFiles, targetDir, targetName, dels, act);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> dearchive(List<File>,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testDearchive_15()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> files = null;
		File targetDir = new File("/");

		List<File> result = fixture.dearchive(files, targetDir);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> dearchive(List<File>,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testDearchive_16()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> files = new Vector();
		File targetDir = new File("/");

		List<File> result = fixture.dearchive(files, targetDir);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> dearchive(List<File>,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testDearchive_17()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> files = new Vector();
		File targetDir = new File("/");

		List<File> result = fixture.dearchive(files, targetDir);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> dearchive(List<File>,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testDearchive_18()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> files = new Vector();
		File targetDir = new File("/");

		List<File> result = fixture.dearchive(files, targetDir);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> dearchive(List<File>,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testDearchive_19()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> files = new Vector();
		File targetDir = new File("/");

		List<File> result = fixture.dearchive(files, targetDir);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> dearchive(List<File>,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testDearchive_20()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> files = new Vector();
		File targetDir = new File("/");

		List<File> result = fixture.dearchive(files, targetDir);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> dearchive(List<File>,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testDearchive_21()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> files = new Vector();
		File targetDir = new File("/");

		List<File> result = fixture.dearchive(files, targetDir);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> dearchive(List<File>,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testDearchive_22()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> files = new Vector();
		File targetDir = new File("/");

		List<File> result = fixture.dearchive(files, targetDir);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> dearchive(List<File>,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testDearchive_23()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> files = new Vector();
		File targetDir = new File("/");

		List<File> result = fixture.dearchive(files, targetDir);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> dearchive(List<File>,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testDearchive_24()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> files = new Vector();
		File targetDir = new File("/");

		List<File> result = fixture.dearchive(files, targetDir);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> dearchive(List<File>,File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testDearchive_25()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> files = new Vector();
		File targetDir = new File("/");

		List<File> result = fixture.dearchive(files, targetDir);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the List<File> dearchive(List<File>,File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testDearchive_26()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> files = new Vector();
		File targetDir = new File("/");
		boolean act = true;

		List<File> result = fixture.dearchive(files, targetDir, act);

		// add additional test code here
		assertNull(result);
	}

	/**
	 * Run the List<File> dearchive(List<File>,File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testDearchive_27()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> files = new Vector();
		File targetDir = new File("/");
		boolean act = true;

		List<File> result = fixture.dearchive(files, targetDir, act);

		// add additional test code here
		assertNull(result);
	}

	/**
	 * Run the List<File> dearchive(List<File>,File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testDearchive_28()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> files = new Vector();
		File targetDir = new File("/");
		boolean act = true;

		List<File> result = fixture.dearchive(files, targetDir, act);

		// add additional test code here
		assertNull(result);
	}

	/**
	 * Run the List<File> dearchive(List<File>,File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testDearchive_29()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> files = new Vector();
		File targetDir = new File("/");
		boolean act = true;

		List<File> result = fixture.dearchive(files, targetDir, act);

		// add additional test code here
		assertNull(result);
	}

	/**
	 * Run the List<File> dearchive(List<File>,File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testDearchive_30()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> files = new Vector();
		File targetDir = new File("/");
		boolean act = true;

		List<File> result = fixture.dearchive(files, targetDir, act);

		// add additional test code here
		assertNull(result);
	}

	/**
	 * Run the List<File> dearchive(List<File>,File,boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:05
	 */
	@Test
	public void testDearchive_31()
		throws Exception {
		TarUtils fixture = new TarUtils();
		List<File> files = new Vector();
		File targetDir = new File("/");
		boolean act = false;

		List<File> result = fixture.dearchive(files, targetDir, act);

		// add additional test code here
		assertNull(result);
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
		new org.junit.runner.JUnitCore().run(TarUtilsTest.class);
	}
}