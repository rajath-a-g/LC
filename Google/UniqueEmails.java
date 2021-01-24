package Google;

import java.util.HashSet;

public class UniqueEmails {
    public static void main(String[] args) {
        String[] arr1 = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        int ans = numUniqueEmails(arr1);
        System.out.println(ans);
    }
    public static int numUniqueEmails(String[] emails) {
        HashSet<String> emailsResult = new HashSet<>();
        for (String email : emails) {
            String[] splitemail = email.split("@");
            StringBuilder first = new StringBuilder();
            for (char c : splitemail[0].toCharArray()) {
                if (c == '+') break;
                if (c  != '.')
                    first.append(c);
            }
            first.append("@");
            first.append(splitemail[1]);
            emailsResult.add(first.toString());
        }
        return emailsResult.size();
    }
}
