
/**
 * @author Monic Bhanushali
 *
 * Description : http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 *
 */
public class SubMatrix01 {

    public static void main(String[] args) {

        int M[][] =
                {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        findTheLargestSubMatrix(M);


    }

    private static void findTheLargestSubMatrix(int[][] inArray) {

        int[][] matrix = new int[inArray.length][inArray[0].length];

        for (int rowOne=0; rowOne<inArray.length; rowOne++){
            matrix[rowOne] = inArray[rowOne];
        }

        for (int colOne=0; colOne<inArray.length; colOne++){
            matrix[colOne] = inArray[colOne];
        }

        int max_subArr_size = 0;
        int max_row_no=0,max_col_no=0;
        for (int i=1;i<inArray.length; i++){
            for (int j=1; j<inArray[0].length; j++){

                if(inArray[i][j] == 1){
                    matrix[i][j] = Math.min(inArray[i-1][j-1], Math.min(inArray[i-1][j], inArray[i][j-1])) + 1;

                    if(max_subArr_size < matrix[i][j]){
                        max_subArr_size = matrix[i][j];
                        max_col_no = j;
                        max_row_no = i;
                    }
                }else{
                    matrix[i][j] = inArray[i][j];
                }

            }
        }

        System.out.println("Array-size=" + max_subArr_size + "\nCo-ordinate (row,col) = " + (max_row_no-(max_subArr_size-1))+"," + (max_col_no-(max_subArr_size-1)));

    }

}
