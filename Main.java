import java.util.Scanner;

public class Main {

    int left;
    int right;

    public static void main(String[] args) {
        System.out.println("Enter the number of elements in array :");
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int array[] = new int[len];
        for(int i =1; i<=len; i++) {
            System.out.println("Enter number " + (i-1) + "of array");
            array[i-1] = scan.nextInt();
        }
        long starttime = System.currentTimeMillis();
        quicksort(array);
        long endtime = System.currentTimeMillis();
        long elapsedtime = endtime - starttime;
        System.out.println("Sorted array is :");
        for (int i=0; i<len; i++) {
            System.out.println(array[i]);
        }
        System.out.println("Time taken to execute in milliseconds is : " + elapsedtime);
    }
    public static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }
    public static void quicksort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = array[(left + right)/ 2];
        int index = partition(array, left, right, pivot);
        quicksort(array, left, index-1);
        quicksort(array, index, right);
    }
    private static int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
    public static void swap(int[] array, int a1, int a2) {
        int temp = array[a2];
        array[a2] = array[a1];
        array[a1] = temp;
    }
}
