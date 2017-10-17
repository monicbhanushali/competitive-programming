package com.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Problem Description:</br>
 * A magic number is defined as a number which can be expressed as a power of 5 or sum of unique powers of 5. 
 * First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5),150(125 + 25), 155(125 + 25 +5), 625, 630(625 + 5),.. 
 * Write a function to find the nth Magic number.
 * 
 * @author Monic.Bhanushali
 *
 */
public class MagicNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int position = 0;
		try {
			position = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			reader.close();
			writer.close();
		}
		long number = findNthMagicNumber(position);
		writer.write(number+"");
		reader.close();
	}

	private static long findNthMagicNumber(int position) {
		
		String binaryString = Integer.toBinaryString(position);
		long result = 0;
		for (int i = 0; i <= binaryString.length()-1 ; i++) {
			if(binaryString.charAt(i)=='1'){
				int power = binaryString.length()-i;
				result = result + (long)Math.pow(5, power);
			}
		}
		return result;
	}

}
