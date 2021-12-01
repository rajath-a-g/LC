package March2021;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllInOneHard {
    private Bucket head;
    private Bucket tail;
    private Map<Integer, Bucket> map;
    private Map<String, Integer> keyMap;

    private class Bucket {
        int count;
        Set<String> keySet;
        Bucket next;
        Bucket pre;
        public Bucket(int cnt) {
            count = cnt;
            keySet = new HashSet<>();
        }
    }

    public AllInOneHard() {
        head = new Bucket(-1);
        tail = new Bucket(-1);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
        keyMap = new HashMap<>();
    }
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {

    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {

    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return null;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return null;
    }
}
