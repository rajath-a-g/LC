package Grokking.TwoPointer;

public class MostWater {
    public static void main(String[] args) {
        System.out.println("Max area:" + maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
        System.out.println("Max area:" + maxArea(new int[] {1, 1}));
        System.out.println("Max area:" + maxArea(new int[] {4,3,2,1,4}));
        System.out.println("Max area:" + maxArea(new int[] {1,2,1}));
    }
    public static int maxArea(int[] height) {
        int l = 0, h = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (l < h) {
           max = Math.max(max, Math.min(height[l], height[h]) * (h - l));
           if (height[l] < height[h])
               l++;
           else
               h--;
        }
        return max;
    }
}
