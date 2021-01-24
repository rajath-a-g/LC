package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println("Combinations are:" + letterCombinations.letterCombinations("23"));
        System.out.println("Combinations are:" + letterCombinations.letterCombinations(""));
        System.out.println("Combinations are:" + letterCombinations.letterCombinations("2"));
    }
    public static Map<String, String> combiMap = new HashMap<String, String>() {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };
    public List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            findCombinations("", digits);
        return result;

    }

    private void findCombinations(String digits, String leftDigits) {
        if (leftDigits.length() == 0)
            result.add(digits);
        else {
            String digit = leftDigits.substring(0, 1);
            String letters = combiMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                findCombinations(digits + letter, leftDigits.substring(1));
            }
        }
    }
}
