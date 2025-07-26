class Solution {
   public long maxSubarrays(int n, int[][] conflictingPairs) {
        List<Integer>[] right=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            right[i]=new ArrayList<>();
        }
        for(int [] x:conflictingPairs){
            right[Math.max(x[0],x[1])].add(Math.min(x[0],x[1]));
        }

        long ans=0;
        long gain[]=new long[n+1];
        int m=0;
        int s=0;
        long add=0;
        for(int r=1;r<=n;r++){
            for(int l:right[r]){
                if(l>m){
                    s=m;
                    m=l;
                }
                else{
                    s=Math.max(l,s);
                }
            }
            ans+= (long) (r-m);
            gain[m]+=(long)(m-s);
            add=Math.max(add,gain[m]);
        }
        return ans+add;
    }
}