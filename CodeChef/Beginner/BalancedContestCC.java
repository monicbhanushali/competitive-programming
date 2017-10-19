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
import java.util.StringTokenizer;

/**
 * Problem Description : https://www.codechef.com/problems/PERFCONT
 * @author Monic.Bhanushali
 *
 */
public class BalancedContestCC {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int nTestCases = Integer.parseInt(reader.readLine());
		writer.flush();
		ArrayList<Integer[]> caseInputs = new ArrayList<>();
		
		//First element is the total Number of participants
		Integer[] input;
		StringTokenizer st;
		while(nTestCases>0){
			st = new StringTokenizer(reader.readLine(), " ");
			int nProblems = Integer.parseInt(st.nextToken());
			input = new Integer[nProblems+1];
			input[0] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(reader.readLine(), " ");
			for (int i = 1; i <= nProblems; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			caseInputs.add(input);
			nTestCases--;
		}
		StringBuilder builder = new StringBuilder();
		builder.append(checkIfContestBalanced(caseInputs.get(0)));
		caseInputs.remove(0);
		for(Integer[] caseInput : caseInputs){
			builder.append("\n").append(checkIfContestBalanced(caseInput));
		}
		System.out.println(builder.toString());
	}

	private static String checkIfContestBalanced(Integer[] caseInput) {
		
		int nParticipants = caseInput[0];
		int hardLevel = nParticipants/10;
		int cakeWalkLevel = nParticipants/2;
		
		int countHard=0;
		int countEasy=0;
		for (int i = 1; i < caseInput.length; i++) {
			if(caseInput[i] <= hardLevel)
				countHard++;
			if(caseInput[i] >= cakeWalkLevel)
				countEasy++;
		}
		
		if(countHard==2 && countEasy==1)
			return "yes";
		else
			return "no";
	}

}
