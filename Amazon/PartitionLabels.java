package Amazon;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        System.out.println("Partitions are:" + partitionLabels("ababcbacadefegdehijhklij"));
    }

    public static List<Integer> partitionLabels(String S) {
        int[] lastCharIndex = new int[26];
        for (int i = 0; i < S.length(); i++)
            lastCharIndex[S.charAt(i) - 'a'] = i;
        int partitionStart = 0, partitionEnd = 0;
        List<Integer> partitionLenList = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            partitionEnd = Math.max(partitionEnd, lastCharIndex[S.charAt(i) - 'a']);
            if (partitionEnd == i) {
                partitionLenList.add(partitionEnd - partitionStart + 1);
                partitionEnd = i + 1;
                partitionStart = i + 1;
            }
        }
        return partitionLenList;
    }
}
