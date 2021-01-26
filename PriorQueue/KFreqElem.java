package PriorQueue;

import java.util.*;

public class KFreqElem {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // create Hash Map
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry.getKey());
            if (queue.size() > k)
                queue.poll();
        }
        int[] result = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            result[i] = queue.poll();
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = { 1, 1, 1, 2, 2, 3, 4, 5, 6 };
        topKFrequent(input, 2);
    }
}
