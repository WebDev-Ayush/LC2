import java.util.*;

class Solution {
    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        LinkedList<Long> stack = new LinkedList<>();
        for (int x : nums) {
            long cur = x;
            while (!stack.isEmpty()) {
                long g = gcd(stack.peekLast(), cur);
                if (g == 1) break;
                cur = lcm(stack.pollLast(), cur);
            }
            stack.add(cur);
        }
        List<Integer> res = new ArrayList<>();
        for (long v : stack) res.add((int) v);
        return res;
    }
}
