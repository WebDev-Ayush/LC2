class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n==1) return 1;

        int minidx=0;
        int maxidx=0;

        for(int i=0;i<n;i++){
            if(nums[i]<nums[minidx]){
                minidx=i;
            }
            if(nums[i]>nums[maxidx]){
                maxidx=i;
            }
        }

            int left=Math.min(minidx,maxidx);
            int right=Math.max(minidx,maxidx);

            int optn1=right+1;
            int optn2=n-left;
            int optn3=(left+1)+(n-right);

            return Math.min(optn1,Math.min(optn2,optn3));
        
    }
}