/*
 * Copyright (c) 2020 Author: Rajath
 */

public class Leet541 {
    public static void main(String[] args) {
        Leet541 leet541 = new Leet541();
        String str1 = "abcdefg";
        int k1 = 2;
        String res1 = leet541.reverseStr(str1, k1);
        System.out.println(res1);
    }

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length, i = 0;
        while (i < n) {
            int j = Math.min(i + k - 1, n - 1);
            swap(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }
    void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
}
