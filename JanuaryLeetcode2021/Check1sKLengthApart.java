package JanuaryLeetcode2021;

public class Check1sKLengthApart {
    public static void main(String[] args) {
        System.out.println("Are they K length apart?" + kLengthApart(new int[] {1,0,0,0,1,0,0,1}, 2));
        System.out.println("Are they K length apart?" + kLengthApart(new int[] {1,0,0,1,0,1}, 2));
        System.out.println("Are they K length apart?" + kLengthApart(new int[] {1,1,1,1,1}, 0));
        System.out.println("Are they K length apart?" + kLengthApart(new int[] {0,1,0,1}, 1));
    }
    public static boolean kLengthApart(int[] nums, int k) {
        int count = k;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (count < k)
                    return false;
                count = 0;
            } else
                count++;
        }
        return true;
    }
}
