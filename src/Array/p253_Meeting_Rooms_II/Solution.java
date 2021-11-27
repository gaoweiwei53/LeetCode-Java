package p253_Meeting_Rooms_II;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int minMeetingRooms(int[][] intervals) {

        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }

        // Min heap
        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>(intervals.length, (a, b) -> a - b);

        // Sort the intervals by start time
        //按照 开始时间 对会议进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Add the first meeting
        allocator.add(intervals[0][1]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // If the room due to free up the earliest is free, assign that room to this meeting.
            // 如果当前会议的开始时间大于最小堆的堆顶元素，即大于最早的会议结束时间
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals[i][1]);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }


    public static void main(String[] args) {
//        int[][] input = new int[][]{{0,30},{5,10},{15,20}};
        int[][] input = new int[][]{{7,10},{2,4}};

    }

}
