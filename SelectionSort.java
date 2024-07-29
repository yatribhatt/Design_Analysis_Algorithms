public class SelectionSort {

    public static void main(String[] args) {
        // Worst Case
        int[] worstCaseArray = generateDescendingArray(1000);
        System.out.println("Selection Sort - Worst Case:");
        System.out.println("Before sorting:");
        printArray(worstCaseArray);
        long startTime = System.currentTimeMillis();
        selectionSort(worstCaseArray);
        long endTime = System.currentTimeMillis();
        System.out.println("After sorting:");
        printArray(worstCaseArray);
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");

        // Best Case
        int[] bestCaseArray = generateAscendingArray(1000);
        System.out.println("\nSelection Sort - Best Case:");
        System.out.println("Before sorting:");
        printArray(bestCaseArray);
        startTime = System.currentTimeMillis();
        selectionSort(bestCaseArray);
        endTime = System.currentTimeMillis();
        System.out.println("After sorting:");
        printArray(bestCaseArray);
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");

        // Average Case
        int[] averageCaseArray = generateRandomArray(1000);
        System.out.println("\nSelection Sort - Average Case:");
        System.out.println("Before sorting:");
        printArray(averageCaseArray);
        startTime = System.currentTimeMillis();
        selectionSort(averageCaseArray);
        endTime = System.currentTimeMillis();
        System.out.println("After sorting:");
        printArray(averageCaseArray);
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
    }

    public static int[] generateDescendingArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }

    public static int[] generateAscendingArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        for (int i = size - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }

    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < Math.min(20, array.length); i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
