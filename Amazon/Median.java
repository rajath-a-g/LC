package Amazon;

class GFG {
    static int[] a = new int[]{900};
    static int[] b = new int[]{10, 13, 14};

    static int maximum(int a, int b) {
        return Math.max(a, b);
    }

    static int minimum(int a, int b) {
        return  Math.min(a, b);
    }

    static double findMedianSortedArrays(int n,
                                         int m) {

        int min_index = 0,
                max_index = n, i = 0,
                j = 0, median = 0;

        while (min_index <= max_index) {
            i = (min_index + max_index) / 2;
            j = ((n + m + 1) / 2) - i;
            if (i < n && j > 0 && b[j - 1] > a[i])
                min_index = i + 1;
            else if (i > 0 && j < m && b[j] < a[i - 1])
                max_index = i - 1;
            else {
                if (i == 0)
                    median = b[j - 1];
                else if (j == 0)
                    median = a[i - 1];
                else
                    median = maximum(a[i - 1],
                            b[j - 1]);
                break;
            }
        }
        if ((n + m) % 2 == 1)
            return (double) median;
        if (i == n)
            return (median + b[j]) / 2.0;
        if (j == m)
            return (median + a[i]) / 2.0;

        return (median + minimum(a[i],
                b[j])) / 2.0;
    }
}
