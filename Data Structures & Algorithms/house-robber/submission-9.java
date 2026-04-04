class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        if(nums.length==2)return Math.max(nums[0],nums[1]);
        // int []dp=new int[nums.length];
        // dp[0]=nums[0];
        // dp[1]=Math.max(nums[1],nums[0]);
        // for(int i=2;i<nums.length;i++){
        //   dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        // }
        // return dp[nums.length-1];
        int prev2=0,prev1=0;
        for(int num:nums){
            int temp=Math.max(prev1,prev2+num);
            prev2=prev1;
            prev1=temp;
        }
        return prev1;
    }
}
