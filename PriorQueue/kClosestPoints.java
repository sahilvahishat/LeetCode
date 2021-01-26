package PriorQueue;

import java.util.*;

public class kClosestPoints {
    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> ((b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]))); // sqrt(sq b - sq a)
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > K) {
                maxHeap.remove(); // remove farthest
            }
        }

        int[][] result = new int[K][2]; // return k closest

        while (!maxHeap.isEmpty()) {
            K--;
            result[K] = maxHeap.remove();
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points = { { 1, 3 }, { -2, 2 } };
        kClosest(points, 1);
    }

}