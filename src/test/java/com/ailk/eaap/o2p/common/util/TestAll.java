package com.ailk.eaap.o2p.common.util;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all
 * of the tests within its package as well as within any subpackages of its
 * package.
 *
 * @generatedBy CodePro at 15-12-10 上午9:07
 * @author windy
 * @version $Revision: 1.0 $
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	Bzip2UtilsTest.class,
	CompressExceptionTest.class,
	CompressUtilsTest.class,
	FileExUtilsTest.class,
	GzipUtilsTest.class,
	IArchiveTest.class,
	ICompressTest.class,
	MultiMemberGZIPInputStreamTest.class,
	TarUtilsTest.class,
	TimestampToolTest.class,
	ZipUtilsTest.class
})
public class TestAll {

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 15-12-10 上午9:07
	 */
	public static void main(String[] args) {
		JUnitCore.runClasses(new Class[] { TestAll.class });
	}
}
