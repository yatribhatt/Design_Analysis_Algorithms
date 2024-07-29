import java.util.Random;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = generateRandomArray(100);
        
        System.out.println("Heap Sort:");
        System.out.println("Before sorting:");
        printArray(array);
        
        heapSort(array);
        
        System.out.println("After sorting:");
        printArray(array);
    }

    public static void heapSort(int[] array) {
        int n = array.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // One by one extract elements
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is an index in array[]
    public static void heapify(int[] array, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // See if left child of root exists and is greater than root
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // See if right child of root exists and is greater than root
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // Change root, if needed
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
    }

    // A utility function to print the array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Generate an array with random integers
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(1000); // Random integers between 0 and 999
        }
        return array;
    }
}
