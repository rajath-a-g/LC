/*
 * Copyright (c) 2020 Author: Rajath
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet1192 {
    public static void main(String[] args) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        ArrayList<Integer> edge1 = new ArrayList<>();
        edge1.add(0);
        edge1.add(1);
        listOfLists.add(edge1);
        ArrayList<Integer> edge2 = new ArrayList<>();
        edge2.add(1);
        edge2.add(2);
        listOfLists.add(edge2);
        ArrayList<Integer> edge3 = new ArrayList<>();
        edge3.add(2);
        edge3.add(0);
        listOfLists.add(edge3);
        ArrayList<Integer> edge4 = new ArrayList<>();
        edge4.add(1);
        edge4.add(3);
        listOfLists.add(edge4);
        Leet1192 leet1192 = new Leet1192();
        List<List<Integer>> res1 = leet1192.criticalConnections(4, listOfLists);
        System.out.println(Arrays.deepToString(res1.toArray()));
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] discover = new int[n], low = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        List<List<Integer>> res = new ArrayList<>();
        Arrays.fill(discover, -1);
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < connections.size(); i++) {
            int from = connections.get(i).get(0), to = connections.get(i).get(1);
            graph[from].add(to);
            graph[to].add(from);
        }

        for (int i = 0; i < n; i++) {
            if (discover[i] == -1) dfs(i, low, discover, graph, res, i);
        }
        return res;
    }

    int time = 0;

    public void dfs(int u, int[] low, int[] disc, List<Integer>[] graph, List<List<Integer>> res, int pre) {
        disc[u] = low[u] = time++;
        for (int j = 0; j < graph[u].size(); j++) {
            int v = graph[u].get(j);
            if (v == pre) continue;
            if (disc[v] == -1) {
                dfs(v, low, disc, graph, res, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    res.add(Arrays.asList(u, v));
                } else {
                    low[u] = Math.min(low[u], disc[v]);
                }
            }
        }

    }
}
