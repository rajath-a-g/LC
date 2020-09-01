import java.util.*;
import java.util.stream.Collectors;

public class Leet692 {
    public static void main(String[] args) {
        Leet692 leet692 = new Leet692();
        String[] test1 = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> res1 = leet692.topKFrequent(test1, 2);
        System.out.println(Arrays.toString(res1.toArray()));
        String[] test2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        List<String> res2 = leet692.topKFrequent(test2, 4);
        System.out.println(Arrays.toString(res2.toArray()));
        List<String> res3 = leet692.topKFrequent2(test1, 2);
        System.out.println(Arrays.toString(res3.toArray()));
        List<String> res4 = leet692.topKFrequent2(test2, 4);
        System.out.println(Arrays.toString(res4.toArray()));
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        frequency.entrySet()
                .stream()
                .sorted((a, b) -> {
                    if (a.getValue() == b.getValue()) return a.getKey().compareTo(b.getKey());
                    else {
                        if (b.getValue() > a.getValue()) return 1;
                        else return 0;
                    }
                })
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        Set<String> res = frequency.keySet();
        System.out.println(frequency.toString());
        List<String> result = new ArrayList<>();
        int num = 0;
        for (String s : res) {
            if (num == k) break;
            result.add(s);
            num++;
        }
        return result;
    }

    public List<String> topKFrequent2(String[] words, int k) {
        HashMap<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> res = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()
        );
        res.addAll(frequency.entrySet());
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(res.poll().getKey());
        }
        return result;
    }
}
