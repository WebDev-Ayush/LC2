public class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] tree = new int[2 * n + 2];
        
        int currentSum = 0;
        int totalSubarrays = 0;
        
        update(tree, n + 1, 1);
        
        for (int i = 0; i < n; i++) {
            currentSum += (nums[i] == target) ? 1 : -1;
            totalSubarrays += query(tree, currentSum + n);
            update(tree, currentSum + n + 1, 1);
        }
        
        return totalSubarrays;
    }
    
    private void update(int[] tree, int i, int delta) {
        while (i < tree.length) {
            tree[i] += delta;
            i += i & -i;
        }
    }
    
    private int query(int[] tree, int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= i & -i;
        }
        return sum;
    }
}