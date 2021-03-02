package Google;

public class FindAccessCodes {
    public static int solution(int[] l) {
        int numCombinations = 0;
        int[] numOfDoubles = new int[l.length];
        for (int i = 1; i < l.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (l[i] % l[j] == 0)
                    numOfDoubles[i]++;
            }
        }
        for (int i = 2; i < l.length; i++) {
            for (int j = 1; j < i; j++) {
                if (l[i] % l[j] == 0)
                    numCombinations += numOfDoubles[j];
            }
        }
        return numCombinations;
    }
}
