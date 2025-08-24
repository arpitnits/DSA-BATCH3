package Backtracking;

public class NQueen {

    static boolean isSafe(int row, int col, int n, char[][] queenPosition) {
        int dupRow, dupCol;

        //left
        dupCol = col;
        while(dupCol>=0) {
            if(queenPosition[row][dupCol]=='Q') return false;
            dupCol--;
        }

        //upper Diagonal
        dupRow = row;
        dupCol = col;
        while(dupRow>=0 && dupCol>=0) {
            if(queenPosition[dupRow][dupCol]=='Q')  return false;
            dupRow--;
            dupCol--;
        }

        //lower Diagonal
        dupRow = row;
        dupCol = col;
        while(dupRow<n && dupCol>=0) {
            if(queenPosition[dupRow][dupCol]=='Q')  return false;
            dupRow++;
            dupCol--;
        }

        return true;
    }

    static void printAllQueens(char[][] matrix, int n) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    static void findAllPath(int col, int n, char[][] queenPosition) {
        //All queen are placed
        if(col==n) {
            printAllQueens(queenPosition, n);
            return;
        }

        //For each col, try all possible rows
        for(int row=0;row<n;row++) {
            if(isSafe(row, col, n, queenPosition)) {
                queenPosition[row][col] = 'Q';
                findAllPath(col+1, n, queenPosition); //Try to place in next Column
                queenPosition[row][col] = '.'; //backtracking
            }
        }
    }


    static void solveNQueen(int n) {
        char[][] queenPosition = new char[n][n];
        //Prefill with "."
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                queenPosition[i][j] = '.';
            }
        }

        findAllPath(0, n, queenPosition);

    }
    public static void main(String[] args) {
        solveNQueen(4);
    }
}
