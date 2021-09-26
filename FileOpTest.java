package com.employeepayrolltest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

import com.employeepayroll.FileOp;

public class FileOpTest {
	@Test
	public void givenFileName_AsInput_ShouldReturnTrue_IfExists() {
		FileOp util = new FileOp();
		util.isFileExists("demo.txt");
		Assert.assertTrue(util.isFileExists("demo.txt"));

	}

	@Test
	public void givenFileName_AsInput_ShouldReturnFalse_IfNotExists() throws IOException {
		FileOp util = new FileOp();
		util.deleteFile("demo2.txt");
		Assert.assertFalse(util.isFileExists("demo2.txt"));

	}
	
	@Test
	public void givenDirectoryName_ShoulCreateDirectory_ReturnTrue() throws IOException {
		FileOp util = new FileOp();
		util.createDirectory("lib");
		Assert.assertTrue(Files.isDirectory(Paths.get("/Users/kshamavidyananda/eclipse-workspace/EmployeePayRoll/data/training")));
	}
	
	@Test
	public void givenFileName_AsInput_ShouldCreateFile_ShouldReturntrue() throws IOException {
		FileOp util = new FileOp();
		util.createEmptyFile("demo2.txt");
		Assert.assertTrue(Files.exists(Paths.get("/Users/kshamavidyananda/eclipse-workspace/EmployeePayRoll/data/demo1.txt")));
	}
}
