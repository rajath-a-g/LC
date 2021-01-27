package JanuaryLeetcode2021;

public class ConcatenateBinary {
    public static void main(String[] args) {
        System.out.println("Concatenated number is " + concatenatedBinary(1));
        System.out.println("Concatenated number is " + concatenatedBinary(3));
        System.out.println("Concatenated number is " + concatenatedBinary(12));
    }
    public static int concatenatedBinary(int n) {
        long concatNum = 0;
        for (int i = 1; i <= n; i++) {
            String binary = Integer.toBinaryString(i);
            concatNum = ((concatNum << binary.length()) + i) % 1000000007;
        }
        return (int)concatNum;
    }
}
