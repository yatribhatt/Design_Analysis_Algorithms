// 8) Write a program to implement the knapsack problem using greedy algorithm.


import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;
    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class greedy_2 {
    // Function to get maximum value in knapsack
    static double getMaxValue(Item[] items, int capacity) {
        // Sort items by value-to-weight ratio
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                double r1 = (double) o1.value / o1.weight;
                double r2 = (double) o2.value / o2.weight;
                return Double.compare(r2, r1);
            }
        });

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity == 0) break;
            if (item.weight <= capacity) {
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                totalValue += item.value * ((double) capacity / item.weight);
                capacity = 0;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = { new Item(60, 10), new Item(100, 20), new Item(120, 30) };
        int capacity = 50;
        System.out.println("Maximum value in knapsack = " + getMaxValue(items, capacity));
    }
}
