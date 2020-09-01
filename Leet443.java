/*
 * Copyright (c) 2020 Author: Rajath
 */

public class Leet443 {
    public static void main(String[] args) {
        Leet443 leet443 = new Leet443();
        System.out.println(leet443.compress("aabbccc"));
    }
    public String compress(String message) {
        char[] chars = message.toCharArray();
        if (chars == null || chars.length == 0)
            return null;

        int index = 0, n = chars.length, i = 0;
        while (i < n) {
            char ch = chars[i];
            int j = i;
            while (j < n && chars[i] == chars[j]) { // chars[i..j - 1] are ch.
                j++;
            }
            int freq = j - i; // The frequency of ch.
            chars[index++] = ch;
            if (freq == 1) {

            }
            else if (freq < 10) {
                chars[index++] = (char)(freq + '0');
            }
            else {
                String strFreq = String.valueOf(freq);
                for (char chFreq : strFreq.toCharArray())
                    chars[index++] = chFreq;
            }
            i = j;
        }
        String res = new String(chars);
        return res.substring(0, res.length() - 1);
    }
}
