package DP;

public class maxSubArray {
    public int maxSubArrayTotal(int[] nums) {
        // restart whenever sum < 0 and store total
        int n = nums.length, maxSum = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i - 1] > 0)
                nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }
}