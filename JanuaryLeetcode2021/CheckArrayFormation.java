package JanuaryLeetcode2021;

import java.util.HashMap;
import java.util.Map;

public class CheckArrayFormation {
    public static void main(String[] args) {
        System.out.println("Can it form the array? " + canFormArray(new int[] {85}, new int[][] {{85}}));
        System.out.println("Can it form the array? " + canFormArray(new int[] {15,88}, new int[][] {{88}, {15}}));
        System.out.println("Can it form the array? " + canFormArray(new int[] {49,18,16}, new int[][] {{16,18,49}}));
        System.out.println("Can it form the array? " + canFormArray(new int[] {91,4,64,78}, new int[][] {{78}, {4, 64}, {91}}));
        System.out.println("Can it form the array? " + canFormArray(new int[] {1,3,5,7}, new int[][] {{2,4,6,8}}));
    }
    public static boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> firstPiece = new HashMap<>();
        for (int[] piece : pieces) {
            firstPiece.put(piece[0], piece);
        }
        int start = 0;
        while (start < arr.length) {
            if (firstPiece.containsKey(arr[start])) {
                int[] piece = firstPiece.get(arr[start]);
                for (int i = 0; i < piece.length; i++) {
                    if (arr[start] != piece[i])
                        return false;
                    else
                        start++;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
