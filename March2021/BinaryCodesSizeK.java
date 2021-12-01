package March2021;

import java.util.HashSet;
import java.util.Set;

public class BinaryCodesSizeK {
    public static void main(String[] args) {
        System.out.println("Does it have all codes ?" + hasAllCodes("00110110", 2));
        System.out.println("Does it have all codes ?" + hasAllCodes("00110", 2));
        System.out.println("Does it have all codes ?" + hasAllCodes("0110", 1));
    }
    public static boolean hasAllCodes(String s, int k) {
        Set<String> combi = new HashSet<>();
        for (int i = 0; i + k <= s.length(); i++) {
            combi.add(s.substring(i, i + k));
            if (combi.size() == (1 << k))
                return true;
        }
        return false;
    }
}
