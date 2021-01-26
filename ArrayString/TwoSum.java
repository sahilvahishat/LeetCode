package ArrayString;

import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                // Add curr index and diff value
                result[0] = i;
                result[1] = map.get(diff);
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        twoSum(nums, 9);
    }
}