package MayLC2021;

public class MaxScore {
    public static void main(String[] args) {
        System.out.println("Max score is:" + maxScore(new int[] {1,2,3,4,5,6,1}, 3));
        System.out.println("Max score is:" + maxScore(new int[] {2,2,2}, 2));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int i = 0, j = cardPoints.length - 1;
        int score = 0;
        while(k-- > 0) {
            if (cardPoints[i] > cardPoints[j]) {
                score += cardPoints[i];
                i++;
            } else {
                score += cardPoints[j];
                j--;
            }
        }
        return score;
    }
}
