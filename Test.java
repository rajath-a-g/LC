public class Test {
    public static void main(String[] args) {
        int i, j, value= 1;
        char ch = 'a';
        char print;
        for( i=0; i < 5; i++) {
            print = ch;
            for( j = 0; j <= i; j++) {
                System.out.print((print++));
            }
            System.out.println("");
        }
    }
}
