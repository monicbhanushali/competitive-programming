import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  @author Monic Bhanushali
 *
 *  Problem: http://www.spoj.com/problems/DQUERY/
 *
 *
 */
public class MoAlgorithm {

    static int BLOCK_SIZE=0;

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int arrSize = Integer.parseInt(reader.readLine());
            int[] inputArr = new int[arrSize];
            BLOCK_SIZE = (int) Math.sqrt(arrSize);
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            for (int i = 0; i < arrSize; i++) {
                inputArr[i] = Integer.parseInt(tokenizer.nextToken());
            }

            int nQueries = Integer.parseInt(reader.readLine());
            QueryNode[] queries = new QueryNode[nQueries];

            for (int i = 0; i < nQueries; i++) {
                tokenizer = new StringTokenizer(reader.readLine(), " ");
                queries[i] = new QueryNode(i,Integer.parseInt(tokenizer.nextToken())-1,
                        Integer.parseInt(tokenizer.nextToken())-1);
            }

            int[] resultArr = solveUsingMoAlgorithm(queries, inputArr);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < resultArr.length; i++) {
                builder.append(resultArr[i]).append("\n");
            }

            builder.setLength(builder.length()-1);
            writer.write(builder.toString());

            reader.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static int[] solveUsingMoAlgorithm(QueryNode[] queries, int[] inputArr) {
        Arrays.parallelSort(queries);
        int[] frequencyArr = new int[10000001];
        int[] result = new int[queries.length];
        int start = queries[0].leftPointer;
        int end = start;
        frequencyArr[inputArr[start]]++;
        int count=1;
        for (int i = 0; i < queries.length; i++) {

            while ( start < queries[i].leftPointer){
                frequencyArr[inputArr[start]]--;
                if( frequencyArr[inputArr[start]] == 0 ){
                    count--;
                }
                start++;
            }

            while ( start > queries[i].leftPointer ){
                start--;
                frequencyArr[inputArr[start]]++;
                if( frequencyArr[inputArr[start]] == 1){
                    count++;
                }
            }

            while ( end < queries[i].rightPointer ){
                end++;
                frequencyArr[inputArr[end]]++;
                if( frequencyArr[inputArr[end]] == 1){
                    count++;
                }
            }

            while ( end > queries[i].rightPointer){
                frequencyArr[inputArr[end]]--;
                if ( frequencyArr[inputArr[end]] == 0){
                    count--;
                }
                end--;
            }

            result[queries[i].index] = count;
        }

        return result;
    }
}

class QueryNode implements Comparable<QueryNode>{
    int index;
    int leftPointer;
    int rightPointer;

    QueryNode(int index, int leftPointer, int rightPointer){
        this.index = index;
        this.leftPointer = leftPointer;
        this.rightPointer = rightPointer;
    }

    @Override
    public int compareTo(QueryNode q2) {
        int blockIndex = this.leftPointer%MoAlgorithm.BLOCK_SIZE;
        int otherBlockIndex = q2.leftPointer%MoAlgorithm.BLOCK_SIZE;
        return blockIndex-otherBlockIndex!=0 ? blockIndex-otherBlockIndex : this.rightPointer - q2.rightPointer;
    }

    @Override
    public String toString() {
        return "Query( index=" + this.index
                + ", left=" + this.leftPointer
                + ", right=" + this.rightPointer + " )";
    }
}