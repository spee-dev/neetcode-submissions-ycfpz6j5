class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);
        return Math.max(robf(nums,0,n-1),robf(nums,1,n));
    }
    int robf(int []nums,int start,int end){
        // int prev1=0,prev2=0;
        int len=end-start;
        if(len==1)return nums[start];
        int []dp=new int[len    ];
        dp[0]=nums[start];
        dp[1]=Math.max(nums[start],nums[start+1]);
       
        for(int i=2;i<len;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[start+i]);
        }
       return dp[len-1];
    }
}
