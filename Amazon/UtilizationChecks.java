package Amazon;

public class UtilizationChecks {
    public static void main(String[] args) {
        System.out.println(finalInstances(2, new int[]{25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 80}));
        System.out.println(finalInstances(100000000, new int[]{30, 95, 4, 8, 19, 89}));
        System.out.println(finalInstances(1, new int[]{5, 10, 80}));
        System.out.println(finalInstances(5, new int[]{30, 5, 4, 8, 19, 89 }));
    }
    public static int finalInstances(int instances, int[] averageUtil) {
        int i = 0;
        while(i < averageUtil.length) {
            int newInstances = instances;
            if (averageUtil[i] < 25 && instances > 1) {
                newInstances = newInstances / 2 + (newInstances % 2);
            } else if (averageUtil[i] > 60) {
                newInstances = instances * 2 > 200000000 ? instances : instances * 2;
            }
            if (newInstances != instances) {
                instances = newInstances;
                i += 10;
            } else {
                i++;
            }
        }
        return instances;
    }
}
