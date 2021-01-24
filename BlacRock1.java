import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BlacRock1 {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);

        try {
            double purchasePrice = Double.parseDouble(in.readLine());
            double cash = Double.parseDouble(in.readLine());
            BlacRock1.calculateChange(purchasePrice, cash);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("ERROR");
        }
    }

    /**
     *
     * @param purchasePrice
     * @param cash
     */
    public static void calculateChange(double purchasePrice, double cash) {
        if (purchasePrice == cash) {
            System.out.println("Zero");
        } else if (purchasePrice < cash) {
            double changeToBeReturned = cash - purchasePrice;
            String changeString = Double.toString(changeToBeReturned);
            String[] arrayOfChangeString = changeString.split("\\.");
            long totalPounds = Long.parseLong(arrayOfChangeString[0]);
            long totalPences = Long.parseLong(arrayOfChangeString[1]);
            printPounds(totalPounds);
            printPences(totalPences);
        } else {
            System.out.println("ERROR");
        }
    }

    private static void printPounds(long pounds) {
        int[] changeAvailable = {1, 2, 5, 10, 20, 50};
        String[] number = {"One Pound", "Two Pounds", "Five Pounds", "Ten Pounds", "Twenty Pounds", "Fifty Pounds"};
        printRequiredChange(changeAvailable, number, pounds, "pounds");
    }

    private static void printPences(long pences) {
        int[] changeAvailable = {1, 2, 5, 10, 20, 50};
        String[] number = {"One Pence", "Two Pence", "Five Pence", "Ten Pence", "Twenty Pence", "Fifty Pence"};
        printRequiredChange(changeAvailable, number, pences, "pence");
    }

    private static void printRequiredChange(int[] changeAvailable, String[] number, long n, String type) {
        int len = changeAvailable.length;
        while (n > 0) {
            int pos = 1;
            for (int i = 1; i < len; i++) {
                if (n < changeAvailable[i]) {
                    pos = i;
                    break;
                }
            }
            if (n > changeAvailable[len - 1]) {
                pos = len;
            }
            n -= changeAvailable[pos - 1];
            if (!(type == "pence" && n == 0)) {
                System.out.print(number[pos - 1] + ", ");
            } else
                System.out.print(number[pos - 1]);
        }
    }
}