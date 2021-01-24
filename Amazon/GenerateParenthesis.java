package Amazon;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println("Generated combinations are:" + generateParenthesis(3));
        System.out.println("Generated combinations are:" + generateParenthesis(1));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateCombination(ans, 0, 0, n, "");
        return ans;
    }

    private static void generateCombination(List<String> ans, int openParen, int closeParen, int max, String soFar) {
        if (soFar.length() == max * 2) {
            ans.add(soFar);
            return;
        }
        if (openParen < max)
            generateCombination(ans, openParen+1, closeParen, max, soFar+"(");
        if (closeParen < openParen)
            generateCombination(ans, openParen, closeParen+1, max, soFar+")");
    }
}
