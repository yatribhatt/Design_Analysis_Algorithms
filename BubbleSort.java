//Write a program to sort given elements of an array in ascending order using bubble sort. 
//Analyze the time complexity for best, average and worst case.   

public class BubbleSort {

    public static void main(String[] args) {
        // Worst Case
        int[] worstCaseArray = generateDescendingArray(1000);
        System.out.println("Bubble Sort - Worst Case:");
        System.out.println("Before sorting:");
        printArray(worstCaseArray);
        long startTime = System.currentTimeMillis();
        bubbleSort(worstCaseArray);
        long endTime = System.currentTimeMillis();
        System.out.println("After sorting:");
        printArray(worstCaseArray);
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");

        // Best Case
        int[] bestCaseArray = generateAscendingArray(1000);
        System.out.println("\nBubble Sort - Best Case:");
        System.out.println("Before sorting:");
        printArray(bestCaseArray);
        startTime = System.currentTimeMillis();
        bubbleSort(bestCaseArray);
        endTime = System.currentTimeMillis();
        System.out.println("After sorting:");
        printArray(bestCaseArray);
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");

        // Average Case
        int[] averageCaseArray = generateRandomArray(1000);
        System.out.println("\nBubble Sort - Average Case:");
        System.out.println("Before sorting:");
        printArray(averageCaseArray);
        startTime = System.currentTimeMillis();
        bubbleSort(averageCaseArray);
        endTime = System.currentTimeMillis();
        System.out.println("After sorting:");
        printArray(averageCaseArray);
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");

        // Additional Cases
        // Empty Array
        int[] emptyArray = new int[0];
        System.out.println("\nBubble Sort - Empty Array:");
        System.out.println("Before sorting:");
        printArray(emptyArray);
        bubbleSort(emptyArray);
        System.out.println("After sorting:");
        printArray(emptyArray);

        // Single Element Array
        int[] singleElementArray = {1};
        System.out.println("\nBubble Sort - Single Element Array:");
        System.out.println("Before sorting:");
        printArray(singleElementArray);
        bubbleSort(singleElementArray);
        System.out.println("After sorting:");
        printArray(singleElementArray);
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

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < Math.min(20, array.length); i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
