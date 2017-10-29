/**
 * 
 */
package com.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author Monic.Bhanushali
 * Problem : https://www.codechef.com/problems/PERMUT2
 */
public class AmbiguousPermutations {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		StringBuilder builder = new StringBuilder();
		while(true){
			int number = Integer.parseInt(reader.readLine());
			if(number<=0)
				break;
			st = new StringTokenizer(reader.readLine(), " ");
			int[] inputArr = new int[number];
			for (int i = 0; i <number ; i++) {
				inputArr[i] = Integer.parseInt(st.nextToken());
			}
			builder.append(checkAmbiguity(inputArr)).append("\n");
		}
		
		builder.setLength(builder.length()-1);
		writer.write(builder.toString());
		writer.flush();
	}

	private static String checkAmbiguity(int[] inputArr) {
		
		String result="ambiguous";
		
		for (int i = 0; i < inputArr.length; i++) {
			if(inputArr[inputArr[i]-1] != (i+1)){
				result = "not ambiguous";
				break;
			}
		}
		
		return result;
	}

}
