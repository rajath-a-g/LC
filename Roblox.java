// Java program to demonstrate working of Collections.sort()
// to descending order.
import java.util.*;

public class Roblox
{
    public static void main(String[] args)
    {
        // Create a list of strings
        ArrayList<String> al = new ArrayList<String>();
        al.add("Louis 9");
        al.add("Louis 8");
        al.add("Dear");
        al.add("Is");
        al.add("Superb");

		/* Collections.sort method is sorting the
		elements of ArrayList in ascending order. */
        Collections.sort(al);

        // Let us print the sorted list
        System.out.println("List after the use of" +
                " Collection.sort() :\n" + al);
    }

    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int num : nums) {
            list.add(Integer.toString(num));
        }
        Collections.sort(list, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String num : list) {
            sb.append(num);
        }
        return sb.toString();
    }
}

