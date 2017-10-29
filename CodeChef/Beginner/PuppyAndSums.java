/**
 * 
 */
package com.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author Monic.Bhanushali
 * Problem : https://www.codechef.com/problems/PPSUM
 */
public class PuppyAndSums {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		StringBuilder builder = new StringBuilder();
		int nCases = Integer.parseInt(reader.readLine());
		while(nCases>0){
			st = new StringTokenizer(reader.readLine(), " ");
			long d = Long.parseLong(st.nextToken());
			long n = Long.parseLong(st.nextToken());
			builder.append(puppySum(d, n)).append("\n");
			nCases--;
		}
		builder.setLength(builder.length()-1);
		writer.write(builder.toString());
		writer.flush();
	}

	private static long puppySum(long d, long n) {
		
		if(d==1)
			return ((n*(n+1))/2);
		else{
			d--;
			long newSum = ((n*(n+1))/2);
			return puppySum(d, newSum);
		}
	}

}
