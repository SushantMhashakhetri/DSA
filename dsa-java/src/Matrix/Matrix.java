package Matrix;

public class Matrix {
  //Search in a row and column wise sorted matrix
    public void search(int target,int[][] matrix, int n) {
        int i =0;
        int j= n-1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == target) {
                System.out.format("Element found at!! %d %d",i,j);
            }
            if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

    }

    public void printInSpiral(int[][] matrix) {
//        int i = 0, j =0;
        for (int i=0; i< matrix.length;i++){
//            System.out.println(matrix[i][]);
        }
    }

    public static void main(String[] args) {
        Matrix mat = new Matrix();
        int[][] matrix = new int[4][4];
        // Initialize the elements of the array
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[0][3] = 4;

        matrix[1][0] = 5;
        matrix[1][1] = 6;
        matrix[1][2] = 7;
        matrix[1][3] = 8;

        matrix[2][0] = 9;
        matrix[2][1] = 10;
        matrix[2][2] = 11;
        matrix[2][3] = 12;
        mat.search(3,matrix,matrix.length); // matrix[0].length

    }
}
