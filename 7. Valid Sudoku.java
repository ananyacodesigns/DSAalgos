/*

VALID SUDOKU

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:

    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.


*/


class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSet = new HashSet[9]; 
        Set<Character>[] colSet = new HashSet[9];
        Set<Character>[] gridSet = new HashSet[9];
        //9 sets for rows
        //9 sets for columns
        //9 sets for grids

        for(int i = 0; i<9; i++){
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            gridSet[i] = new HashSet<>();
        }

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char value = board[i][j];
                if(value=='.'){
                    continue;
                }
                    int g = (i/3)*3 +(j/3);
                    boolean isPresentInRow = rowSet[i].contains(board[i][j]);
                    boolean isPresentInCol = colSet[j].contains(board[i][j]);
                    boolean isPresentInGrid = gridSet[g].contains(board[i][j]);

                    if(isPresentInRow || isPresentInCol || isPresentInGrid){
                        return false;
                    }
                    rowSet[i].add(value);
                    colSet[j].add(value);
                    gridSet[g].add(value);
              }
            }
            return true;
    }
}
