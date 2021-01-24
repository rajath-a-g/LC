package JanuaryLeetcode2021;

public class LargestHistogram {
    public static void main(String[] args) {
        System.out.println("Max Area:" + largestRectangleArea(new int[] {2,1,5,6,2,3}));
    }
    public static int largestRectangleArea(int[] heights) {
        int l = 0, h = heights.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (l < h) {
            maxArea = Math.max(maxArea, (Math.min(heights[l], heights[h]) * (h - l)));
            if (heights[l] < heights[h])
                l++;
            else
                h--;
        }
        return maxArea;
    }
}
