package FebLC2021;

public class NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println("Number of 1 bit is " + hammingWeight(Integer.parseInt("00000000000000000000000000001011", 2)));
        System.out.println("Number of 1 bit is " + hammingWeight(Integer.parseInt("00000000000000000000000010000000", 2)));
    }
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n = n >>> 1; // unsigned shift
        }
        return count;
    }
}
