import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println("Enter the number of elements :");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int array[] = new int[number];
        Random random = new Random();
        for (int i =0 ; i < number ; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println("The array of unsorted random numbers is : ");
        for (int i = 0 ; i < number; i++) {
            System.out.println(array[i]);
        }
        Instant startTime = Instant.now();
        //double startTime = System.nanoTime();
        mergesort(array);
        Instant endTime = Instant.now();
        //double endTime = System.nanoTime();
        //long totalTime = Duration.between(startTime, endTime).toSeconds();
        System.out.println("The array of sorted random numbers is : ");
        for (int i = 0 ; i < number; i++) {
            System.out.println(array[i]);
        }
        //System.out.println("Time taken to sort is :" + totalTime + " Seconds");
    }
    public static void mergesort(int[] array) {
        mergesort(array, new int[array.length], 0, array.length-1);
    }
    public static void mergesort(int [] array, int[] temp, int left, int right) {
        if(left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        mergesort(array, temp, 0, middle);
        mergesort(array, temp, middle + 1, right);
        mergeHalves(array, temp, left, right);
    }

    public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
        //leftend is the calculated by the middle of the array +1
        int leftEnd = (rightEnd + leftStart) / 2;
        //right start is just after the leftend
        int rightStart = leftEnd + 1;
        //total size of the array
        int size = rightEnd - leftStart + 1;
        //left and right indexes
        int left = leftStart;
        int right = rightStart;
        //index of the temp array
        int index = leftStart;
        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }
        //Only one of the below two calls are made
        // Copy remaining elements in left half
        System.arraycopy(array, left, temp, index, leftEnd - left + 1);
        //Copy remaining elements in right half
        System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        //Copy the temp array to result array
        System.arraycopy(temp, leftStart, array, leftStart, size);
    }
}
