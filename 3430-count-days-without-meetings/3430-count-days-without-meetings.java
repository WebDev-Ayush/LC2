import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int countDays(int days, int[][] meetings) {
        if (meetings.length == 0) {
            return days;
        }

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(meetings[0]);

        for (int i = 1; i < meetings.length; i++) {
            int[] last = merged.get(merged.size() - 1);
            int[] current = meetings[i];

            if (current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                merged.add(current);
            }
        }

        int totalMeetingDays = 0;
        for (int[] interval : merged) {
            int start = Math.max(interval[0], 1);
            int end = Math.min(interval[1], days);
            if (start <= end) {
                totalMeetingDays += end - start + 1;
            }
        }

        return days - totalMeetingDays;
    }
}