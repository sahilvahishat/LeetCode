package DP;

import java.util.*;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp_array = new int[amount + 1]; // 12
        Arrays.fill(dp_array, amount + 1);
        dp_array[0] = 0;

        for (int i = 1; i < dp_array.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                int amount_check = i - coins[j];

                if (amount_check >= 0) { // we can use this coin
                    int num_coins = Math.min(dp_array[amount_check] + 1, dp_array[i]);
                    // 4==> coin(1) => min(dp[3] +1, 12) = 4 coins of 1 or min(dp[2] + 1, 4) = 2
                    dp_array[i] = num_coins;
                }

            }
        }
        if (dp_array[amount] == amount + 1)
            return -1;
        return dp_array[amount];
    }

    public static void main(String[] args) {
        int[] input = { 2 };// { 1, 2, 5 };
        coinChange(input, 3);
    }

}