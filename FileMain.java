package com.employeepayroll;

import java.io.IOException;

public class FileMain {
	static String path = "/Users/kshamavidyananda/eclipse-workspace/EmployeePayRoll/data";
	public static void main(String[] args) throws IOException {
		FileOp fileUtil = new FileOp();
		

		// checking whether file exists or not
		System.out.println(fileUtil.isFileExists("demo.txt"));


		// deleting the file and checking whether file exists or not
		fileUtil.deleteFile("demo.txt");
		System.out.println(fileUtil.isFileExists("demo.txt"));
		System.out.println("File deleted");


		// creating a directory
		fileUtil.createDirectory("training");
		System.out.println("Created directory");
		
		//create a empty file
		fileUtil.createEmptyFile("demo1.txt");

		
		//list directories and files
		fileUtil.listFilesDirectories(path);
		System.out.println(path);
	}
}
