package com.aventstack.extentreports.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
//import org.junit.Test;

public class CopyFileUtil {

	public CopyFileUtil() {
	}

	private static final String SOURCEPATH = "com/aventstack/extentreports/view/html-report/jsandcss/";
	private static final String ENCODING = "UTF-8";

	public void copyClasspathResource(String outputDirectory, String resourceName, String targetFileName)
			throws IOException {
		String resourcePath = SOURCEPATH + resourceName;
		System.out.println(getClass().getClassLoader().getResource(SOURCEPATH + resourceName));
		InputStream resourceStream = getClass().getClassLoader().getResourceAsStream(resourcePath);
		copyStream(outputDirectory, resourceStream, targetFileName);
	}

	protected void copyFile(String outputDirectory, File sourceFile, String targetFileName) throws IOException {
		InputStream fileStream = new FileInputStream(sourceFile);
		try {
			copyStream(outputDirectory, fileStream, targetFileName);
		} finally {
			fileStream.close();
		}
	}

	protected void copyStream(String outputDirectory, InputStream stream, String targetFileName) throws IOException {
		// File resourceFile = new File(outputDirectory, targetFileName);
		File file = new File(outputDirectory, targetFileName);
		BufferedReader reader = null;
		Writer writer = null;
		try {
			reader = new BufferedReader(new InputStreamReader(stream, ENCODING));
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), ENCODING));

			String line = reader.readLine();
			while (line != null) {
				writer.write(line);
				writer.write('\n');
				line = reader.readLine();
			}
			writer.flush();
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (writer != null) {
				writer.close();
			}
		}
	}

	public static void copyResources(String outputDirectory) throws IOException {
		CopyFileUtil copyFIle = new CopyFileUtil();
		copyFIle.copyClasspathResource(outputDirectory, "extent-java.js", "extent-java.js");
		copyFIle.copyClasspathResource(outputDirectory, "extent.js", "extent.js");
		copyFIle.copyClasspathResource(outputDirectory, "extent.css", "extent.css");
		copyFIle.copyClasspathResource(outputDirectory, "Icons.css", "Icons.css");
		copyFIle.copyClasspathResource(outputDirectory, "sans.css", "sans.css");

	}

	// @Test
	// public void testcoyb() throws IOException {
	// CopyFileUtil.copyResources("E:\\test");
	// }

}
