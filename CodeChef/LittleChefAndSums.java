import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Solution to Codechef's Sept Long Challenge problem.
 * Problem Link : https://www.codechef.com/SEPT17/problems/CHEFSUM
 *
 * @author Monic.Bhanushali
 *
 */
public class LittleChefAndSums {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int nCases = Integer.parseInt(st.nextToken());
		int inArray[];
		int arraySize;
		while(nCases>0){
			arraySize = Integer.parseInt(br.readLine());
			inArray = new int[arraySize];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < arraySize; i++) {
				inArray[i] = Integer.parseInt(st.nextToken());
			}
			System.out.println(newApproach(inArray));
			nCases--;
		}
	}

	private static int newApproach(int[] array){
		int result=-1;
		long minSum = Long.MAX_VALUE;

		long totalSum = 0;

		for (int i = 0; i < array.length; i++) {
			totalSum =totalSum + array[i];
		}

		long previousPrefixSum =0;
		for (int i = 0; i < array.length; i++) {
			long suffixSum = totalSum - previousPrefixSum;
			long prefixSum = previousPrefixSum + array[i];
			previousPrefixSum = prefixSum;
			long sum = prefixSum + suffixSum;
			if(sum<minSum){
				minSum = sum;
				result = i+1;
			}
		}

		return result;
	}
}

