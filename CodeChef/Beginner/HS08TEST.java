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
 *
 */
public class HS08TEST {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
		
		float withdrawal = Float.parseFloat(tokenizer.nextToken());
		float initialBal = Float.parseFloat(tokenizer.nextToken());
		float finalBal = initialBal;
		float bankCharge = (float) 0.50;
		String output=String.format("%.2f", initialBal);
		if(withdrawal%5==0 && (withdrawal+bankCharge)<=initialBal){
			
			finalBal = finalBal-(withdrawal+bankCharge);
			output = String.format("%.2f", finalBal);
		}
		
		writer.write(output);
		writer.flush();
	}

}
