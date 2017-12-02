/**
 * @author Monic Bhanushali
 *
 * Description : Maximum Sum 2 non overlapping subarrays of given size
 * Link : http://www.geeksforgeeks.org/maximum-sum-two-non-overlapping-subarrays-of-given-size/
 *
 * Algorithm used in below code is slight modification of Kadane's algorithm and runs in O(N) time [N=array_size]
 *
 */
public class NonOverlappingArrayProblem {

    public static void main(String[] args) {

        int[] inputArr = new int[]{10,1,3,15,30,40,4,50,2,1};

        int k = 3;
        String results = getTheMaxSubarrays(inputArr,k);
        System.out.println(results);
    }

    private static String getTheMaxSubarrays(int[] inputArr, int k) {

        int[] prefixSumArr = getPrefixSumArray(inputArr);

        int startIndex_subarr1=0;
        int startIndex_subarr2=k;
        int endIndex_subarr1 = startIndex_subarr1 + k-1;
        int endIndex_subarr2 = startIndex_subarr2 + k-1;
        int arr1_index=startIndex_subarr1;
        int arr2_index=startIndex_subarr2;
        int sum_so_far = prefixSumArr[2*k-1];

        for (int i=endIndex_subarr2+1; i<inputArr.length; i++){

            startIndex_subarr1++;
            endIndex_subarr1++;
            int subArrSum1 = prefixSumArr[endIndex_subarr1] - prefixSumArr[startIndex_subarr1-1];
            startIndex_subarr2++;
            endIndex_subarr2++;
            int subArrSum2 = prefixSumArr[endIndex_subarr2] - prefixSumArr[startIndex_subarr2-1];

            int newSum = subArrSum1+subArrSum2;

            if(newSum > sum_so_far){
                sum_so_far=newSum;
                arr1_index = startIndex_subarr1;
                arr2_index = startIndex_subarr2;
            }

        }

        return "" + sum_so_far + " " + arr1_index + " " + arr2_index;
    }

    /**
     * Method to calculate prefix of all subarrays in the given array.
     * @param inputArr
     * @return
     */
    private static int[] getPrefixSumArray(int[] inputArr) {

        int[] result = new int[inputArr.length];

        result[0] = inputArr[0];
        for (int i =1; i<inputArr.length; i++){
            result[i] = result[i-1] + inputArr[i];
        }
    return result;
    }

}

