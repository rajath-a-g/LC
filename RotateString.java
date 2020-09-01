public class RotateString {
    public String rot(String originalString, int[] direction, int[] amount) {
      /*  for (int i = 0; i < amount.length; i++) {
            amount[i] = amount[i] % originalString.length();
        }
        for(int j = 0; j < direction.length; j++) {
            for(int k = 0; k < originalString.length(); k++) {
                originalString.rotate
            }
        }
        return originalString;*/
    return originalString;
    }
    public static String LeftRot(String input, int times) {
        StringBuilder sb = new StringBuilder();
        int len = input.length();

        for (int i = 0; i < len; i++) {
            if (i < times)
                sb.append(input.charAt(i));
            else
                sb.insert(i-times, input.charAt(i));
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String sample = "ephjos";
        int[] direction = {1,0};
        int[] amount = {7,4};
        RotateString sam = new RotateString();
        String res = sam.rot(sample, direction, amount);
        System.out.println(res);
    }
}
