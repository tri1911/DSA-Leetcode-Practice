package others;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: April 01, 2022
 * 401. Binary Watch
 * https://leetcode.com/problems/binary-watch/
 */

// TODO: implement using backtracking, bit manipulation instead

public class P401 {
    // time: O(n)
    // space: O(1)
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        if (turnedOn > 8) return ans;
        final int[][] buckets = {{0}, {1, 2, 4, 8, 16, 32}, {3, 5, 6, 9, 10, 12, 17, 18, 20, 24, 33, 34, 36, 40, 48}, {7, 11, 13, 14, 19, 21, 22, 25, 26, 28, 35, 37, 38, 41, 42, 44, 49, 50, 52, 56}, {15, 23, 27, 29, 30, 39, 43, 45, 46, 51, 53, 54, 57, 58}, {31, 47, 55, 59}};
        // i <= 3
        // turnedOn - i <= 5 => i >= turnedOn - 5
        for (int i = Math.max(turnedOn - 5, 0); i <= Math.min(turnedOn, 3); i++) {
            StringBuilder sb;
            int j = turnedOn - i;
            for (int hour : buckets[i]) {
                if (hour < 12) {
                    sb = new StringBuilder();
                    sb.append(hour).append(':');
                    for (int minute : buckets[j]) {
                        if (minute < 10) sb.append('0').append(minute);
                        else sb.append(minute);
                        ans.add(sb.toString());
                        sb.deleteCharAt(sb.length() - 1);
                        sb.deleteCharAt(sb.length() - 1);

                    }
                }
            }
        }
        return ans;
    }
}

/* Count 1s in numbers
    int[] dp = new int[60];
    ArrayList<Integer>[] buckets = new ArrayList[11];
    for (int i = 1; i < 60; i++) {
        dp[i] = dp[i >> 1] + (i & 1);
        if (buckets[dp[i]] == null) buckets[dp[i]] = new ArrayList<>();
        buckets[dp[i]].add(i);
    }
 */