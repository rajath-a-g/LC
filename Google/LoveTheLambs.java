package Google;

public class LoveTheLambs {
    public static void main(String[] args) {
        System.out.println("Ans:" + solution(143));
    }
    public static int solution(int total_lambs) {
        int sum = 1, fib1 = 1, fib2 = 1, temp, generous = 0, stingy = 1;
        while (true) {
            sum += fib2;
            if (sum > total_lambs)
                break;
            temp = fib2;
            fib2 = fib1 + fib2;
            fib1 = temp;
            stingy++;
        }
        fib1 = 1;
        sum = 0;
        while (true) {
            sum += fib1;
            if (sum > total_lambs)
                break;
            fib1 *= 2;
            generous++;
        }
        sum -= fib1;
        if ((total_lambs - sum) >= ((fib1 / 2) + (fib1 / 4)))
            generous++;
        return stingy - generous;
    }
}
