package problem.medium.Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int currentIdx = 0;
        while(currentIdx < intervals.length - 1){
            int nextIdx = currentIdx + 1;
            if(intervals[currentIdx][1] >= intervals[nextIdx][0]){
                intervals[nextIdx][0] = intervals[currentIdx][0];
                intervals[nextIdx][1] = Math.max(intervals[currentIdx][1], intervals[nextIdx][1]);
            }  else {
                result.add(new int[]{intervals[currentIdx][0], intervals[currentIdx][1]});
            }
            currentIdx++;
        }
        result.add(new int[]{intervals[intervals.length - 1][0], intervals[intervals.length - 1][1]});

        return result.toArray(new int[result.size()][]);
    }
}