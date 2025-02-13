import java.util.PriorityQueue;

public class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer((long) num);
        }
        int operations = 0;
        while (pq.size() >= 2 && pq.peek() < k) {
            long x = pq.poll();
            long y = pq.poll();
            long newNum = Math.min(x, y) * 2 + Math.max(x, y);
            pq.offer(newNum);
            operations++;
        }
        return operations;
    }
}