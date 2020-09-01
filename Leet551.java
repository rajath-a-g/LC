/*
 * Copyright (c) 2020 Author: Rajath
 */

public class Leet551 {
    public static void main(String[] args) {
        Leet551 leet551 = new Leet551();
        boolean res = leet551.checkRecord("");
    }
    public boolean checkRecord(String s) {
        int numA = 0;
        int numL = 0;
        for (char c : s.toCharArray()) {
            if(c == 'A') {
                numL = 0;
                numA++;
                if (numA > 1) return false;
            } else if (c == 'L') {
                numL++;
                if(numL > 2) return false;
            } else {
                numL = 0;
            }
        }
        return true;
    }
}
