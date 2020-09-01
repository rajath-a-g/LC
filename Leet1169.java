/*
 * Copyright (c) 2020 Author: Rajath
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet1169 {
    public static void main(String[] args) {
        Leet1169 leet1169 = new Leet1169();
        String[] tran1 = {"alice,20,800,mtv","alice,50,100,beijing"};
        List<String> res = leet1169.invalidTransactions(tran1);
        System.out.println(Arrays.deepToString(res.toArray()));
    }

    public List<String> invalidTransactions(String[] transactions) {
        List<String> res = new ArrayList<>();
        int n = transactions.length;
        if (n == 0) return res;
        String[] name = new String[n];
        int[] time = new int[n];
        int[] money = new int[n];
        String[] city = new String[n];
        boolean[] add = new boolean[n];
        for (int i = 0; i < n; i++) {
            String[] unit = transactions[i].split(",");
            name[i] = unit[0];
            time[i] = Integer.parseInt(unit[1]);
            money[i] = Integer.parseInt(unit[2]);
            city[i] = unit[3];
        }
        for (int i = 0; i < n; i++) {
            if (money[i] > 1000) add[i] = true;
            for (int j = i + 1; j < n; j++) {
                if (name[i].equals(name[j]) && Math.abs(time[i] - time[j]) <= 60 && !city[i].equals(city[j])) {
                    add[i] = true;
                    add[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (add[i]) res.add(transactions[i]);
        }
        return res;
    }
}
