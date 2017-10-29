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
 * Problem : https://www.codechef.com/problems/FRUITS
 */
public class ChefAndFruits {

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
			long nApples = Long.parseLong(st.nextToken());
			long nOranges = Long.parseLong(st.nextToken());
			long nCoins = Long.parseLong(st.nextToken());
			
			builder.append(minimizeDiff(nApples, nOranges, nCoins)).append("\n");
			nCases--;
		}
		builder.setLength(builder.length()-1);
		writer.write(builder.toString());
		writer.flush();
	}

	private static long minimizeDiff(long nApples, long nOranges, long nCoins) {
		
		long diff=0;
		
		long minFruit = nApples;
		long maxFruit = nOranges;
		if(nOranges<minFruit)
			minFruit=nOranges;
		if (nApples>maxFruit) {
			maxFruit=nApples;
		}
		if((minFruit+nCoins)>= maxFruit){
			diff=0;
		}else{
			diff = maxFruit-(minFruit+nCoins);
		}
		
		return diff;
	}

}
