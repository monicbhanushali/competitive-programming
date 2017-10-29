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
 * Problem : https://www.codechef.com/problems/PERMUT2
 */
public class TransformExpression {

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
			builder.append(transformExprsn(reader.readLine())).append("\n");
			nCases--;
		}

		builder.setLength(builder.length()-1);
		writer.write(builder.toString());
		writer.flush();
	}

	private static String transformExprsn(String expr){
		ArrayList<Character> resultStk = new ArrayList();
		Stack<Character> temp = new Stack<>();

		for (int i = 0; i < expr.length(); i++) {
			char curr = expr.charAt(i);
			if(curr == '(' || curr=='+' || curr=='/' || curr=='*' || curr=='-' || curr=='^' || curr=='%' ){
				temp.push(curr);
			}else{
				if(curr >= 'a' && curr <= 'z'){
					resultStk.add(curr);
				}else{
					if (!temp.isEmpty()) {
						resultStk.add(temp.pop());
					}
					if (!temp.isEmpty()) {
						temp.pop();
					}
				}
			}
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < resultStk.size(); i++) {
			result.append(resultStk.get(i));
		}
		resultStk=null;
		temp=null;
		return result.toString();
	}
}
