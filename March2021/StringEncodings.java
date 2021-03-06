package March2021;

import java.util.HashMap;
import java.util.Map;

public class StringEncodings {
    public static void main(String[] args) {
        System.out.println("Len of min len encoding:" + minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }

    public static int minimumLengthEncoding(String[] words) {
        TrieNode trie = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode cur = trie;
            for (int j = word.length() - 1; j >= 0; j--)
                cur = cur.get(word.charAt(j));
            nodes.put(cur, i);
        }
        int ans = 0;
        for (TrieNode t : nodes.keySet()) {
            if (t.count == 0)
                ans += words[nodes.get(t)].length() + 1;
        }
        return ans;
    }
}

class TrieNode {
    TrieNode[] children;
    int count;

    TrieNode() {
        children = new TrieNode[26];
        count = 0;
    }

    public TrieNode get(char c) {
        if (children[c - 'a'] == null) {
            children[c - 'a'] = new TrieNode();
            count++;
        }
        return children[c - 'a'];
    }
}
