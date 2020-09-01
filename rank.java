import java.util.*;

import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.toMap;

public class rank {
    public int fIrank(List<List<Integer>> marks, int k) {
        List<Integer> sum = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < marks.size(); i++) {
            int sum1 = 0;
            for(int j = 0; j < marks.get(0).size(); j++) {
                sum1 = sum1 + marks.get(i).get(j);
            }
            map.put(sum1, i);
        }
        Map<Integer,Integer> sorted = map.entrySet() .stream() .sorted(comparingByKey())
                .collect(toMap(e -> e.getKey(), e -> e.getValue(), (e2, e1) -> e2));
        int res = ((int)sorted.get(k));
        return res;
    }
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        //matrix.set(new ArrayList<>()
        matrix.get(1).set(2,96);
        matrix.get(1).set(3,81);
        matrix.get(1).set(4,77);
        matrix.get(2).set(1,78);
        matrix.get(2).set(2,71);
        matrix.get(2).set(3,93);
        matrix.get(2).set(4,75);
        matrix.get(3).set(1,71);
        matrix.get(3).set(2,98);
        matrix.get(3).set(3,70);
        matrix.get(3).set(4,95);
        rank r = new rank();
        int rank1 = r.fIrank(matrix, 2);
        System.out.println(rank1);
    }
}
