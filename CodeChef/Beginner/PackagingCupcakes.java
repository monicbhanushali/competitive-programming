/**
 * 
 */
package com.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Monic.Bhanushali
 * Problem : https://www.codechef.com/problems/MUFFINS3
 */
public class PackagingCupcakes {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int nTestCases = Integer.parseInt(reader.readLine());
		
		long[] output = new long[nTestCases];
		for (int i = 0; i < nTestCases; i++) {
			long inputNo = Integer.parseInt(reader.readLine());
			output[i] = (inputNo/2) + 1;
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append(output[0]);
		
		for (int i = 1; i < output.length; i++) {
			builder.append("\n").append(output[i]);
		}
		
		writer.write(builder.toString());
		writer.flush();
	}

}
