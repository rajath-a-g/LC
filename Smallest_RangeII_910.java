import java.util.Arrays;

public class Smallest_RangeII_910 {
    public static void main(String[] args) {
        int[] input_arr_1 = {1};
        int k1 = 0;
        int ans1 = smallestRangeII(input_arr_1, k1);
        System.out.println("Result1 : " + ans1);
        int[] input_arr_2 = {0, 10};
        int k2 = 2;
        int ans2 = smallestRangeII(input_arr_2, k2);
        System.out.println("Result2 : " + ans2);
        int[] input_arr_3 = {1, 3, 6};
        int k3 = 3;
        int ans3 = smallestRangeII(input_arr_3, k3);
        System.out.println("Result3 : " + ans3);
    }
    public static int smallestRangeII(int[] A, int K) {
        int n = A.length;
        Arrays.sort(A);
        int mx = A[n - 1], mn = A[0], res = mx - mn;
        for(int i = 0; i < n - 1; i++) {
            System.out.println("A[i] :" + A[i] + "A[i+1]: " + A[i+1]);
            mx = Math.max(mx, A[i] + 2 * K);
            mn = Math.min(A[i + 1], A[0] + 2 * K);
            res = Math.min(res, mx - mn);
        }
        return res;
    }
}
