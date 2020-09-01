import java.util.ArrayList;
import java.util.List;

public class Leet748 {
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        //Remove all spaces in the given license and it would not match to any character in the words.
        licensePlate = licensePlate.replaceAll("\\s+", "");
        char[] plateChars = licensePlate.toLowerCase().toCharArray();
        String res = "";
        int min = Integer.MAX_VALUE;
        int count = 0;
        List<Character> plateList = new ArrayList<>();
        //Add all characters to a list
        for (char c : plateChars) {
            if (!Character.isDigit(c))
                plateList.add(c);
        }
        for (String word : words) {
            count = 0;
            List<Character> wordList = new ArrayList<>();
            //Make list with all the characters of the the word in the loop
            for (char c : word.toCharArray()) {
                wordList.add(c);
            }
            for (char d : plateList) {
                //Check if the word list contains the licence plate letter
                if (wordList.contains(d)) {
                    count++;
                    wordList.remove((Character) d);
                } else {
                    continue;
                }
                //Keep track of the shortest word where the count
                // and the size of the chars in the plate is equal
                if (count == plateList.size() && min > word.length()) {
                    res = word;
                    min = word.length();
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String license = "iMSlpe4";
        String[] words = {"claim", "consumer", "student", "camera", "public", "never", "wonder", "simple", "thought", "use"};
        String res = shortestCompletingWord(license, words);
        System.out.println(res);
        String lic1 = "1s3 PSt";
        String[] words1 = {"step", "steps", "stripe", "stepple"};
        String res1 = shortestCompletingWord(lic1, words1);
        System.out.println(res1);
        String licensePlate1 = "1s3 456";
        String[] words2 = {"looks", "pest", "stew", "show"};
        String res2 = shortestCompletingWord(licensePlate1, words2);
        System.out.println(res2);
        String trial2 = "Ah71752";
        String[] trial3 = {"suggest", "letter", "of", "husband", "easy", "education", "drug", "prevent", "writer", "old"};
        String res3 = shortestCompletingWord(trial2, trial3);
        System.out.println(res3);
    }
}
