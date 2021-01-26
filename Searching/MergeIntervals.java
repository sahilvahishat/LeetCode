package Searching;

import java.util.*;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        int[][] result;
        int index = 0;
        List<Integer> inner;
        List<List<Integer>> outer = new ArrayList<>();
        // sort intervals
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        if (intervals.length == 0 || intervals.length == 1)
            return intervals;

        // add first interval to output
        int current_Interval_start = intervals[0][0];
        int current_Interval_end = intervals[0][1];
        inner = new ArrayList<>();
        inner.add(current_Interval_start);
        inner.add(current_Interval_end);
        outer.add(inner);

        for (int i = 1; i < intervals.length; i++) { // update curr end till you can
            if (current_Interval_end >= intervals[i][0]) {
                current_Interval_end = Math.max(intervals[i][1], current_Interval_end); // [1,6]
                inner = new ArrayList<>();
                inner.add(current_Interval_start);
                inner.add(current_Interval_end);
                outer.set(index, inner);// update curr end and add new
            } else {
                index++;
                current_Interval_start = intervals[i][0];
                current_Interval_end = intervals[i][1];
                inner = new ArrayList<>();
                inner.add(current_Interval_start);
                inner.add(current_Interval_end);
                outer.add(inner);
            }
        }

        result = new int[outer.size()][2];
        System.out.println(result);

        for (int i = 0; i < outer.size(); i++) { // [[1,2] [3,4]]
            result[i][0] = outer.get(i).get(0);
            result[i][1] = outer.get(i).get(1);
        }

        return result;

    }

    public static void main(String[] args) {
        int[][] input = { { 2, 3 }, { 2, 2 }, { 3, 3 }, { 1, 3 }, { 2, 2 }, { 4, 6 } };
        merge(input);
    }
}