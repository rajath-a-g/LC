import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Enter the number :");
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        if (len == reverse(len)) {
            System.out.println(len + " is a palindrome number.");
        }
        else {
            System.out.println(len + " is not a palindrome number" + " as the reverse number is " + reverse(len));
        }
    }
    public static int reverse(int number) {
        if(number > 9) {
            int rem;
            int reverse = 0;
            int i=1;
            while (number > 0) {
                rem = number%10;
                reverse = (reverse * 10) + rem ;
                number = number/10;
            }
            return reverse;
        }
        else {
            return number;
        }
    }
}
