package leetcodingchallenge.march2022;

/**
 * Date: March 06, 2022
 * 1359. Count All Valid Pickup and Delivery Options
 * https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/
 */

// TODO: practice the approach using math & probability (time: O(n))

public class P1359 {
    private int MOD = 1_000_000_007;

    // dynamic programming (tabular approach)
    // time: O(n^2)
    // space: O(n^2)
    public int countOrders(int n) {
        long[][] dp = new long[n + 1][n + 1];
        for (int unpicked = 0; unpicked <= n; unpicked++) {
            for (int undelivered = 0; undelivered <= n; undelivered++) {
                if (unpicked == 0 && undelivered == 0) {
                    dp[unpicked][undelivered] = 1;
                } else {
                    if (unpicked > 0) {
                        dp[unpicked][undelivered] += (unpicked * dp[unpicked - 1][undelivered]) % MOD;
                    }
                    if (unpicked < undelivered) {
                        dp[unpicked][undelivered] += ((undelivered - unpicked) * dp[unpicked][undelivered - 1]) % MOD;
                    }
                }
            }
        }
        return (int) dp[n][n];
    }

    public static void main(String[] args) {
        P1359 obj = new P1359();
        System.out.println("Expected: 1. Received: " + obj.countOrders(1));
        System.out.println("Expected: 6. Received: " + obj.countOrders(2));
        System.out.println("Expected: 90. Received: " + obj.countOrders(3));
        System.out.println("Expected: 764678010. Received: " + obj.countOrders(500));
    }
}

/**
 * reference
 * https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/solution/
 */
