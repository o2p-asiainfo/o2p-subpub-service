package com.ailk.eaap.o2p.common.util;

import java.io.File;
import java.util.List;
import java.util.Vector;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>FileExUtilsTest</code> contains tests for the class <code>{@link FileExUtils}</code>.
 *
 * @generatedBy CodePro at 15-12-10 上午9:06
 * @author windy
 * @version $Revision: 1.0 $
 */
public class FileExUtilsTest {
	
	/**
	 * Run the List deepCopy(List) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testDeepCopy_1()
		throws Exception {
		List src = new Vector();

		List result = FileExUtils.deepCopy(src);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the List deepCopy(List) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testDeepCopy_2()
		throws Exception {
		List src = new Vector();

		List result = FileExUtils.deepCopy(src);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the List deepCopy(List) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testDeepCopy_3()
		throws Exception {
		List src = new Vector();

		List result = FileExUtils.deepCopy(src);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the List deepCopy(List) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testDeepCopy_4()
		throws Exception {
		List src = new Vector();

		List result = FileExUtils.deepCopy(src);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the List deepCopy(List) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testDeepCopy_5()
		throws Exception {
		List src = new Vector();

		List result = FileExUtils.deepCopy(src);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the List deepCopy(List) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testDeepCopy_6()
		throws Exception {
		List src = new Vector();

		List result = FileExUtils.deepCopy(src);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the List<Object> deepCopyT(List<T>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testDeepCopyT_1()
		throws Exception {
		List<Object> src = new Vector();

		List<Object> result = FileExUtils.deepCopyT(src);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the List<Object> deepCopyT(List<T>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testDeepCopyT_2()
		throws Exception {
		List<Object> src = new Vector();

		List<Object> result = FileExUtils.deepCopyT(src);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the void deleteFile(File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testDeleteFile_1()
		throws Exception {
		File file = new File("");

		FileExUtils.deleteFile(file);

		// add additional test code here
	}

	/**
	 * Run the void deleteFile(File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testDeleteFile_2()
		throws Exception {
		File file = new File("");

		FileExUtils.deleteFile(file);

		// add additional test code here
	}

	/**
	 * Run the void deleteFile(File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testDeleteFile_3()
		throws Exception {
		File file = new File("");

		FileExUtils.deleteFile(file);

		// add additional test code here
	}

	/**
	 * Run the void deleteFile(File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testDeleteFile_4()
		throws Exception {
		File file = new File("");

		FileExUtils.deleteFile(file);

		// add additional test code here
	}

	/**
	 * Run the File getDefaultTemplateDirectory() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testGetDefaultTemplateDirectory_1()
		throws Exception {

		File result = FileExUtils.getDefaultTemplateDirectory();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoSuchMethodError: org.apache.commons.io.FileUtils.getTempDirectory()Ljava/io/File;
		//       at com.ailk.eaap.o2p.common.util.FileExUtils.getDefaultTemplateDirectory(FileExUtils.java:134)
		assertNotNull(result);
	}

	/**
	 * Run the File getDefaultTemplateDirectory(File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testGetDefaultTemplateDirectory_2()
		throws Exception {
		File directoryFile = new File("");

		File result = FileExUtils.getDefaultTemplateDirectory(directoryFile);

		// add additional test code here
//		assertNotNull(result);
//		assertEquals(0L, result.length());
//		assertEquals(false, result.isAbsolute());
//		assertEquals(null, result.list());
//		assertEquals(false, result.canExecute());
//		assertEquals(false, result.canRead());
//		assertEquals(false, result.canWrite());
//		assertEquals(false, result.exists());
//		assertEquals(0L, result.getFreeSpace());
//		assertEquals(0L, result.getTotalSpace());
//		assertEquals(0L, result.getUsableSpace());
//		assertEquals(false, result.isDirectory());
//		assertEquals(false, result.isFile());
//		assertEquals(false, result.isHidden());
//		assertEquals(0L, result.lastModified());
//		assertEquals(null, result.listFiles());
	}

	/**
	 * Run the File getDefaultTemplateDirectory(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testGetDefaultTemplateDirectory_3()
		throws Exception {
		String directoryFile = "";

		File result = FileExUtils.getDefaultTemplateDirectory(directoryFile);

		// add additional test code here
//		assertNotNull(result);
//		assertEquals(0L, result.length());
//		assertEquals(false, result.isAbsolute());
//		assertEquals(null, result.list());
//		assertEquals(false, result.canExecute());
//		assertEquals(false, result.canRead());
//		assertEquals(false, result.canWrite());
//		assertEquals(false, result.exists());
//		assertEquals(0L, result.getFreeSpace());
//		assertEquals(0L, result.getTotalSpace());
//		assertEquals(0L, result.getUsableSpace());
//		assertEquals(false, result.isDirectory());
//		assertEquals(false, result.isFile());
//		assertEquals(false, result.isHidden());
//		assertEquals(0L, result.lastModified());
//		assertEquals(null, result.listFiles());
	}

	/**
	 * Run the int getFileSize(List) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testGetFileSize_1()
		throws Exception {
		List files = new Vector();

		int result = FileExUtils.getFileSize(files);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the File getTemplateFile() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testGetTemplateFile_1()
		throws Exception {

		File result = FileExUtils.getTemplateFile();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoSuchMethodError: org.apache.commons.io.FileUtils.getTempDirectory()Ljava/io/File;
		//       at com.ailk.eaap.o2p.common.util.FileExUtils.getTemplateFile(FileExUtils.java:100)
		assertNotNull(result);
	}

	/**
	 * Run the File getTemplateFile(File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testGetTemplateFile_2()
		throws Exception {
		File directoryFile = new File("");

		File result = FileExUtils.getTemplateFile(directoryFile);

		// add additional test code here
//		assertNotNull(result);
//		assertEquals(0L, result.length());
//		assertEquals(false, result.isAbsolute());
//		assertEquals(null, result.list());
//		assertEquals(false, result.canExecute());
//		assertEquals(false, result.canRead());
//		assertEquals(false, result.canWrite());
//		assertEquals(false, result.exists());
//		assertEquals(0L, result.getFreeSpace());
//		assertEquals(0L, result.getTotalSpace());
//		assertEquals(0L, result.getUsableSpace());
//		assertEquals(false, result.isDirectory());
//		assertEquals(false, result.isFile());
//		assertEquals(false, result.isHidden());
//		assertEquals(0L, result.lastModified());
//		assertEquals(null, result.listFiles());
	}

	/**
	 * Run the File getTemplateFile(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testGetTemplateFile_3()
		throws Exception {
		String directory = "";

		File result = FileExUtils.getTemplateFile(directory);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0L, result.length());
		assertEquals(null, result.list());
		assertEquals(false, result.canExecute());
		assertEquals(false, result.canRead());
		assertEquals(false, result.canWrite());
		assertEquals(false, result.exists());
		assertEquals(0L, result.getFreeSpace());
		assertEquals(0L, result.getTotalSpace());
		assertEquals(0L, result.getUsableSpace());
		assertEquals(false, result.isDirectory());
		assertEquals(false, result.isFile());
		assertEquals(false, result.isHidden());
		assertEquals(0L, result.lastModified());
		assertEquals(null, result.listFiles());
	}

	/**
	 * Run the String getTimeByFormat(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testGetTimeByFormat_1()
		throws Exception {
		String format = "";

		String result = FileExUtils.getTimeByFormat(format);

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the int hexStringToAlgorism(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testHexStringToAlgorism_1()
		throws Exception {
		String hex = "";

		int result = FileExUtils.hexStringToAlgorism(hex);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int hexStringToAlgorism(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testHexStringToAlgorism_2()
		throws Exception {
		String hex = "";

		int result = FileExUtils.hexStringToAlgorism(hex);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int hexStringToAlgorism(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testHexStringToAlgorism_3()
		throws Exception {
		String hex = "";

		int result = FileExUtils.hexStringToAlgorism(hex);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the int hexStringToAlgorism(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:06
	 */
	@Test
	public void testHexStringToAlgorism_4()
		throws Exception {
		String hex = "";

		int result = FileExUtils.hexStringToAlgorism(hex);

		// add additional test code here
		assertEquals(0, result);
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
		new org.junit.runner.JUnitCore().run(FileExUtilsTest.class);
	}
}