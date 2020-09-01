public class NetBeez {
    public static int[] giveCoordinates(int a, int x, int y, String directions) {
        char[] direct = directions.toUpperCase().toCharArray();
        for(char d : direct) {
            if(d == 'U') {
                if(x - 1 >= 0) x--;
            }
            else if(d == 'D') {
                if(x + 1 <= a - 1) x++;
            }
            else if(d == 'R') {
                if(y + 1 > a - 1) y = 0;
                else y++;
            } else {
                if(y - 1 < 0) y = a - 1;
                else y--;
            }
        }
        return new int[] {x, y};
    }
    public static void main(String[] args) {
        int[] ans = NetBeez.giveCoordinates(3, 1, 0, "LLUU");
        int[] ans1 = NetBeez.giveCoordinates(3, 0, 0,"RDD");
        for(int i = 0; i < 2; i++) {
            System.out.println(ans[i]);
        }
        for(int i = 0; i < 2; i++) {
            System.out.println(ans1[i]);
        }
    }
}
