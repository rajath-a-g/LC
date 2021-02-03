package Amazon;

public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println("Converted string is " + convert("PAYPALISHIRING", 3));
        System.out.println("Converted string is " + convert("PAYPALISHIRING", 4));
    }
    public static String convert(String s, int nRows) {
        char[] chars = s.toCharArray();
        StringBuilder[] sb = new StringBuilder[nRows];
        for (int i = 0; i < nRows; i++) sb[i] = new StringBuilder();
        int i = 0;
        while (i < chars.length) {
            for (int j = 0; j < nRows && i < chars.length; j++)
                sb[j].append(chars[i++]);
            for (int j = nRows - 2; j >= 1 && i < chars.length; j--)
                sb[j].append(chars[i++]);
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder str : sb) {
            result.append(str);
        }
        return result.toString();
    }
}
