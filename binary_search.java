import java.util.Scanner;  // Importing Scanner class
import java.util.Arrays;   // Importing Arrays class

public class binary_search {

    public static int sequentialSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // Element found at index i
            }
        }
        return -1; // Element not found
    }

    public static int binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1; // Element not found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Fixed Scanner class issue
        int[] arr = {12, 34, 54, 2, 3};
        System.out.println("Enter element to search: ");
        int key = sc.nextInt();

        // Sequential Search
        int seqIndex = sequentialSearch(arr, key);
        System.out.println("Sequential Search: " + (seqIndex == -1 ? "Not Found" : "Found at index " + seqIndex));

        // Binary Search (array needs to be sorted first)
        Arrays.sort(arr);  // Fixed Arrays class issue
        int binIndex = binarySearch(arr, key);
        System.out.println("Binary Search: " + (binIndex == -1 ? "Not Found" : "Found at index " + binIndex));
    }
}

