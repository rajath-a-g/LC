package March2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

public class VowelChars {
    public static void main(String[] args) {
        System.out.println("Spellchecker result is" + Arrays.toString(spellchecker(new String[] {"KiTe","kite","hare","Hare"}, new String[] {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"})));
    }
    private static HashSet<String> perfect = new HashSet<>();
    private static HashMap<String, String> caseOptimized = new HashMap<>();
    private static HashMap<String, String> vowelOptimized = new HashMap<>();

    public static String[] spellchecker(String[] wordlist, String[] queries) {
        for(String word: wordlist) {
            perfect.add(word);

            String lowerCase = word.toLowerCase();
            caseOptimized.putIfAbsent(lowerCase, word);

            String vowelRemoved = removeVowel(lowerCase);
            vowelOptimized.putIfAbsent(vowelRemoved, word);
        }

        int n = queries.length;
        String[] res = new String[n];
        for(int i = 0; i < n; i++) {
            res[i] = solve(queries[i]);
        }
        return res;
    }

    private static String solve(String query) {
        if(perfect.contains(query)) return query;

        String lowerCase = query.toLowerCase();
        if(caseOptimized.containsKey(lowerCase)) return caseOptimized.get(lowerCase);

        String vowelRemoved = removeVowel(lowerCase);
        if(vowelOptimized.containsKey(vowelRemoved)) return vowelOptimized.get(vowelRemoved);

        return "";
    }

    private static String removeVowel(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            sb.append(isVowel(ch) ? '*' : ch);
        }
        return sb.toString();
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
