import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class sortedHacker {
    public static long sortedArrangement(List<Integer> question) {
        LinkedList<Integer> lList = new LinkedList<>();
        long operations = 1l;
        int countleft = 0, countright = 0;
        lList.add(question.get(0));
        for (int i = 1; i < question.size(); i++) {
            for (int j = 0; j < lList.size(); j++) {
                if (question.get(i) > lList.get(j)) continue;
                else {
                    countleft = (2 * j) + 1;
                    countright += (lList.size() - j) * 2 + 1;
                    lList.add(j, question.get(i));
                    operations += Math.min(countleft, countright);
                }
            }
        }
        return operations;
    }

    public static void main(String[] args) {
        List<Integer> quest = new ArrayList<>();
        quest.add(10);
        quest.add(6);
        quest.add(2);
        quest.add(3);
        quest.add(7);
        quest.add(1);
        quest.add(2);
        long ans = sortedArrangement(quest);
        System.out.println(ans);
    }
}
