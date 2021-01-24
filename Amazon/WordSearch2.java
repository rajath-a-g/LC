package Amazon;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
    public static void main(String[] args) {
        System.out.println("Words present are:" + findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"}));
        System.out.println("Words present are:" + findWords(new char[][] {{'a','b'},{'c','d'}}, new String[] {"abcb"}));
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (exist(board, word))
                result.add(word);
        }
        return result;
    }

    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, dirs, i, j, words, 0)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int[][] dirs, int i, int j, char[] word, int start) {
        if (start == word.length) return true;
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) return false;
        if (board[i][j] == '#' || board[i][j] != word[start]) return false;
        char c = board[i][j];
        board[i][j] = '#';
        boolean res = false;
        for (int[] dir : dirs) {
            int newRow = i + dir[0], newCol = j + dir[1];
            res |= dfs(board, dirs, newRow, newCol, word, start + 1);
            if (res) return true;
        }
        board[i][j] = c;
        return false;
    }
}
