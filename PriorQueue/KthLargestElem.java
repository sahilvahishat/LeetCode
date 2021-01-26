package PriorQueue;

import java.util.*;

public class KthLargestElem {
    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k)
                minHeap.remove();
        }

        return minHeap.remove();
    }

    public static void main(String[] args) {
        int[] input = { 1, 1, 1, 2, 2, 3, 4, 5, 6 };
        findKthLargest(input, 1);
    }
}