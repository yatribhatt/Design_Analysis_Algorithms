import java.util.Scanner;

public class greedy_algo {
    
    public static void findChange(int[] coins, int amount) {
        System.out.println("Coins used to make change for " + amount + ":");
        for (int i = 0; i < coins.length; i++) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                System.out.print(coins[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] coins = {25, 10, 5, 1}; // US currency
        System.out.println("Enter the amount to make change for:");
        int amount = sc.nextInt();

        findChange(coins, amount);
    }
    
}

