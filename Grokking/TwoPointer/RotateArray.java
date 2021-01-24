package Grokking.TwoPointer;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7};
        rotate(arr1, 3);
        System.out.println("Rotated Array is:" + Arrays.toString(arr1));
        int[] arr2 = {-1,-100,3,99};
        rotate(arr2, 2);
        System.out.println("Rotated Array is:" + Arrays.toString(arr2));
    }
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private static void reverse(int[] arr, int begin, int end) {
        while(begin < end) {
            int tmp = arr[begin];
            arr[begin++] = arr[end];
            arr[end--] = tmp;
        }
    }
}
