/*
 * Copyright (c) 2020 Author: Rajath
 */

import java.util.Arrays;

public class Chessboard {
    public static void main(String[] args) {
        Chessboard chessboard = new Chessboard();
        chessboard.generateChessBoard(5);
    }
    private void generateChessBoard(int n) {
       /* String[] rowEven = new String[n];
        String[] rowOdd = new String[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                rowEven[i] = "W";
                rowOdd[i] = "B";
            } else {
                rowOdd[i] = "W";
                rowEven[i] = "B";
            }
        }
        String[][] chessboard = new String[n][n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                chessboard[i] = rowEven;
            } else {
                chessboard[i] = rowOdd;
            }
        }
        chessboard[0][0] = "W";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j > 0 && chessboard[i][j-1] == "W")
                    System.out.println("B");
                else
                    System.out.println("W");
                //System.out.print(chessboard[i][j] + " ");
            }
            System.out.println();
        }*/
        int i = 0;
        String prev = "B";
        String rowPrev = "B";
        while (i < n * n) {
            if (prev == "W") {
                prev = "B";
            } else {
                prev = "W";
            }
            i++;
            System.out.print(prev + " ");
            if (i % n == 0) {
                System.out.println();
                if (rowPrev == "W") {
                    prev = "B";
                    rowPrev = "B";
                } else {
                    rowPrev = "W";
                    prev = "W";
                }

            }
        }
    }
}
