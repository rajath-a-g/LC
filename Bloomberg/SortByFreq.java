package Bloomberg;

import java.util.*;

public class SortByFreq {
    public String frequencySort(String s) {
        Map<Character, Integer> f = new HashMap<>();
        for (char c : s.toCharArray())
            f.put(c, f.getOrDefault(c, 0) + 1);
        PriorityQueue<Character> pq = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(f::get)));
        for (Character c : f.keySet())
            pq.add(c);
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            int count = f.get(c);
            while (count-- > 0)
                sb.append(c);
        }
        return sb.toString();
    }
}
