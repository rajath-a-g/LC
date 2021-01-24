package Amazon;

import java.util.Arrays;
import java.util.HashSet;

public class PrisonCells {
    public static void main(String[] args) {
        System.out.println("After n days we have:" + Arrays.toString(prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7)));
    }
    public static int[] prisonAfterNDays(int[] cells, int N) {
        if (cells == null || cells.length == 0 || N <= 0) return cells;
        boolean hasCycle = false;
        int cycleAfter = 0;
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int[] next = nextDay(cells);
            String nexStr = Arrays.toString(next);
            if (!seen.contains(nexStr)) {
                seen.add(nexStr);
                cycleAfter++;
            } else {
                hasCycle = true;
                break;
            }
            cells = next;
        }
        if (hasCycle) {
            N %= cycleAfter;
            for (int i = 0; i < N; i++)
                cells = nextDay(cells);
        }
        return cells;
    }

    private static int[] nextDay(int[] cells) {
        int[] tmp = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++)
            tmp[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        return tmp;
    }
}
