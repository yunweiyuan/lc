/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 *
 * https://leetcode.com/problems/sudoku-solver/description/
 *
 * algorithms
 * Hard (35.05%)
 * Total Accepted:    120.2K
 * Total Submissions: 335.3K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * A sudoku solution must satisfy all of the following rules:
 * 
 * 
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3
 * sub-boxes of the grid.
 * 
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * 
 * A sudoku puzzle...
 * 
 * 
 * ...and its solution numbers marked in red.
 * 
 * Note:
 * 
 * 
 * The given board contain only digits 1-9 and the character '.'.
 * You may assume that the given Sudoku puzzle will have a single unique
 * solution.
 * The given board size is always 9x9.
 * 
 * 
 */
class Solution {
    public void solveSudoku(char[][] board) {
        solveSudoku(0, 0, board);
    }

    public boolean solveSudoku(int row, int col, char[][] board) {
	if (row >= 9 || col >= 9) {
	    // System.out.println("end of game");
	    return true;
	}	       
	final int next_col = (col + 1) % 9;
	final int next_row = (col + 1) / 9 + row;
        if (board[row][col] == '.') {
	    for (char candidate = '1'; candidate <= '9'; candidate++) {
                if (check(row, col, candidate, board)) {
                    board[row][col] = candidate;
		    boolean solved = solveSudoku(next_row, next_col, board);
		    if (!solved) {
	                board[row][col] = '.';
		    } else {
			System.out.println("true");
	                return true;
		    }
	        }
	    }
	    // System.out.printf("fail row: %d, col: %d. ", row, col);
	    return false;
	} else {
            return solveSudoku(next_row, next_col, board);
	}
    }

    private boolean check(int row, int col, char candidate, char[][] board) {
        return rowCheck(row, candidate, board) &&
		boxCheck(row, col, candidate, board) &&
		colCheck(col, candidate, board);
    }

    private boolean boxCheck(int row, int col, char candidate, char[][] board) {
        final int box_index = (row / 3) * 3 + (col / 3);
	final int start_row_index = box_index / 3 * 3;
	final int start_col_index = box_index % 3 * 3;
	for (int i = start_row_index; i < start_row_index + 3; i++) {
            for (int j = start_col_index; j < start_col_index + 3; j++) {
                if (candidate == board[i][j]) {
                    return false;
		}
	    }
	}
	return true;
    }

    private boolean rowCheck(int row, char candidate, char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == candidate) {
                return false;
	    }
	}
	return true;
    }

    private boolean colCheck(int col, char candidate, char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == candidate) {
                return false;
	    }
	}
	return true;
    }
}
