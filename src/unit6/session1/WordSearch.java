package unit6.session1;

import java.lang.module.FindException;
import java.util.*;

public class WordSearch {

    public static int[][] visited;

    public static boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
//        for (int i = 0; i < w.length; i++) {
//            System.out.println(w[i]);
//        }
        visited = new int[board.length][board[0].length];
        boolean res = false;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if(board[r][c] == w[0])
                    res = wordDFS(board, r, c, 0,w);
                if(res) return true;
            }
        }

        return false;
    }

    public static boolean wordDFS(char[][] board,int i,int j, int index,  char[] word ){
        if(index==word.length) return true;
        if(i<0||j<0||i>=board.length||j>=board[0].length
                ||board[i][j]!=word[index]||visited[i][j]==1){
            return false;
        }
        visited[i][j]=1;
//        boolean up = wordDFS(board, i-1, j, index+1, word);
//        boolean down = wordDFS(board, i+1, j, index+1, word);
//        boolean left = wordDFS(board, i, j-1, index+1, word);
//        boolean right = wordDFS(board, i, j+1, index+1, word);
        boolean found = wordDFS(board, i+1, j, index+1, word) || wordDFS(board, i, j-1, index+1, word)
                || wordDFS(board, i, j+1, index+1, word) || wordDFS(board, i-1, j, index+1, word);
        visited[i][j]  = 0;
        return found;
    }

    public static void main(String[] args) {
//        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        System.out.println(exist(new char[][]{{'H','B','P','E'},{'S','F','P','H'},{'A','L','L','E'}}, "HELP"));
    }

}
