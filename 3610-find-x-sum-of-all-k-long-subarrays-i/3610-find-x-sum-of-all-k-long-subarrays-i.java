class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Map<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] != b[1] ? b[1] - a[1] : b[0] - a[0]
        );

        for (int i = 0; i < k; i++)
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

        ans[0] = calc(freq, pq, x);

        for (int i = k; i < n; i++) {
            int add = nums[i], rem = nums[i - k];
            freq.put(add, freq.getOrDefault(add, 0) + 1);
            freq.put(rem, freq.get(rem) - 1);
            if (freq.get(rem) == 0) freq.remove(rem);
            ans[i - k + 1] = calc(freq, pq, x);
        }

        return ans;
    }

    int calc(Map<Integer, Integer> freq, PriorityQueue<int[]> pq, int x) {
        pq.clear();
        for (var e : freq.entrySet())
            pq.add(new int[]{e.getKey(), e.getValue()});

        int sum = 0, take = x;
        while (take-- > 0 && !pq.isEmpty()) {
            int[] a = pq.poll();
            sum += a[0] * a[1];
        }
        return sum;
    }
}
