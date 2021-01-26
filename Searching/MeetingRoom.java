package Searching;

import java.util.*;

public class MeetingRoom {
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0)
            return 0;

        if (intervals.length == 1)
            return 1;

        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0])); // sort array
        PriorityQueue<Integer> roomTimes = new PriorityQueue<>();

        int cur_room_end = intervals[0][1];
        roomTimes.add(cur_room_end);
        for (int i = 1; i < intervals.length; i++) {
            // if curr == prev exactly update room
            int earliest_room = roomTimes.peek();
            if (intervals[i][0] < earliest_room) { // new start < prev_end book room
                roomTimes.add(intervals[i][1]);
            } else {
                roomTimes.poll();
                roomTimes.add(intervals[i][1]);
            }
        }

        return roomTimes.size();

    }

    public static void main(String[] args) {
        int[][] input = { { 1, 5 }, { 8, 9 }, { 8, 9 } };
        minMeetingRooms(input);
    }
}