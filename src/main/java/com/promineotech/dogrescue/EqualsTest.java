package com.promineotech.dogrescue;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class EqualsTest {

	public static void main(String[] args) {
		try {

			File file1 = new File("/tmp/1");
			File file2 = new File("/tmp/2");

			if (file1.equals(file2)) {
				System.out.println("Files are equal!");
			} else {
				System.out.println("Files are not equal!");
			}

			System.out.println(file1);
			Map<String, String> myString = new HashMap<String, String>();
			myString.put("Test", "Test");

			System.out.println(myString);

			String[] arry = new String[] { "Test" };

			System.out.println(arry);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
