package Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactHackerrank {
    public static class TrieNode {
        int frequency;
        Map<Character, TrieNode> children = new HashMap<>();
        public TrieNode() {
            frequency = 1;
        }
    }

    public static class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void addContact(String s) {
            TrieNode curr = root;
            for (int i = 0; i < s.length(); i++) {
                if (curr.children.containsKey(s.charAt(i))) {
                    curr = curr.children.get(s.charAt(i));
                    curr.frequency++;
                } else {
                    TrieNode newNode = new TrieNode();
                    curr.children.put(s.charAt(i), newNode);
                    curr = newNode;
                }
            }
        }

        public int findPartial(String key) {
            TrieNode curr = root;
            for (int i = 0; i < key.length(); i++) {
                if (!curr.children.containsKey(key.charAt(i)))
                    return 0;
                else {
                    curr = curr.children.get(key.charAt(i));
                }
            }
            return curr.frequency;
        }
    }
    static int[] contacts(String[][] queries) {
        List<Integer> res = new ArrayList<>();
        Trie trie = new Trie();
        for (String[] query : queries) {
            if (query[0].equals("add"))
                trie.addContact(query[1]);
            else
                res.add(trie.findPartial(query[1]));
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}
