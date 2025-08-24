package Backtracking;

public class KnightTour {

    static int[] rowMoves = {2,2,-2,-2,-1,-1,1,1};
    static int[] colMoves = {1,-1,1,-1,2,-2,2,-2};

    public static boolean isSafe(int x, int y, int n, int[][] matrix) {
        if(x>=0 && y>=0 && x<n && y<n && //In-boudary
                matrix[x][y] == -1 ) {  //no visited
            return true;
        }
        return false;
    }

    public static boolean traverse(int x, int y, int n, int move, int[][] matrix) {
        int nextX, nextY;

        if(move == n*n) {
            return true;
        }

        for(int i=0;i<8;i++) {
            nextX = x + rowMoves[i];
            nextY = y + colMoves[i];

            if(isSafe(nextX, nextY, n, matrix)) {
                matrix[nextX][nextY] = move;
                if(traverse(nextX, nextY, n, move+1, matrix)){
                    return true;
                } else {
                    matrix[nextX][nextY] = -1; //backtracking
                }
            }
        }
        return false;
    }

    public static void knightTour(int n) {
        int[][] matrix = new int[n][n];

        //Mark all positions as not visited
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                matrix[i][j] = -1;
            }
        }

        //Assuming that knight will always start from 0,0
        matrix[0][0] = 0;

        if(traverse(0,0,n,1,matrix)) {
            //printSolution
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution exist");
        }
    }

    public static void main(String[] args) {
        knightTour(3);
    }
}
