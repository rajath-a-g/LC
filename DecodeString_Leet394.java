import java.util.Stack;

public class DecodeString_Leet394 {
    public static void main(String[] args) {
        DecodeString_Leet394 decodeString_leet394 = new DecodeString_Leet394();
        System.out.println(decodeString_leet394.decodeString("3[a]2[bc]"));
        System.out.println(decodeString_leet394.decodeString("3[a2[c]]"));
        System.out.println(decodeString_leet394.decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString_leet394.decodeString("100[leetcode]"));
    }

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // If character is not ']' we have to keep track of it
            if (c != ']') {
                stack.push(String.valueOf(c));
            } else {
                // We have to start forming the string
                StringBuilder sb = new StringBuilder();
                // Pop till the first ']' to know which string to repeat
                while (!stack.peek().equals("["))
                    sb.append(stack.pop());
                stack.pop(); // Pop '[' itself
                String resCur = sb.toString(); // Covert to string we will reverse the string the end in the result
                StringBuilder time = new StringBuilder();
                while (!stack.empty() && Character.isDigit(stack.peek().charAt(0))) // There can be multiple digits so pop all
                    time.append(stack.pop());
                int times = Integer.parseInt(time.reverse().toString()); // Get the number of times, Do not forget the reverse
                StringBuilder res = new StringBuilder();
                for (int i = 0; i < times; i++) // Append the string for the given number of times
                    res.append(resCur);
                stack.push(res.toString()); // We have not finished yet push it back
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            result.append(stack.pop()); // keep appending till the stack is empty
        }
        return result.reverse().toString(); // reverse the string in the end
    }
}
