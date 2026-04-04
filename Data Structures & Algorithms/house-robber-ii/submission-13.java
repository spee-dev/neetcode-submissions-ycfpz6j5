class Solution {
    public int rob(int[] nums) {
       int n=nums.length;
       if(n==1)return nums[0];
       if(n==2)return Math.max(nums[0],nums[1]);
       return Math.max(robber(nums,0,n-1),robber(nums,1,n));
    }
    public int robber(int []nums,int start,int end){
        int len=end-start;
        int []dp=new int[len];
        if(len==1){
            return nums[start];
        }
        dp[0]=nums[start];
        dp[1]=Math.max(nums[start],nums[start+1]);
        for(int i=2;i<len;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i+start]);
        }
        return dp[len-1];
    }
}
