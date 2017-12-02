/**
 * @author Monic Bhanushali
 *
 * The series formed from the number of possible ways to tile the board is a fibonacci series.
 * Description: http://www.geeksforgeeks.org/tiling-problem/
 *
 */
public class TilingProblem {

    public static void main(String[] args) {

        int board_size = 4;

        int total_ways_to_tile = countTilingWays(board_size);
        System.out.println(total_ways_to_tile);

    }

    private static int countTilingWays(int board_size) {

        if(board_size == 1 || board_size == 2 || board_size == 3){
            return board_size;
        }else{
            //N-1
            int preSum = 3;
            //N-2
            int grandPreSum = 2;

            int finalSum = 0;
            for (int n=4; n<=board_size; n++){
                finalSum = preSum + grandPreSum;
                grandPreSum = preSum;
                preSum = finalSum;
            }
            return finalSum;
        }
    }

}
