package com.cheny.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N皇后
 * https://leetcode-cn.com/problems/n-queens/
 */
public class LeetCode_41 {


    static List<List<String>> res = new ArrayList<List<String>>();

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        char [][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
        backTranverse(board, 0);
        return res;
    }

    public static void backTranverse(char [][] board, int row) {
        if(row == board.length) {
            res.add(char2str(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if(!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            backTranverse(board, row + 1);
            board[row][col] = '.';
        }
    }

    private static List<String> char2str(char [][] board) {
        List<String> list = new ArrayList();

        for (char[] c : board) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    private static boolean isValid(char [][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if(board[i][col] == 'Q') {
                return  false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0 ; i-- , j--) {
            if(board[i][j] == 'Q') {
                return  false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i-- , j++) {
            if(board[i][j] == 'Q') {
                return  false;
            }
        }
        return true;
    }

}
