class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);
        return Math.max(robf(nums,0,n-1),robf(nums,1,n));
    }
    int robf(int []nums,int start,int end){
        int prev1=0,prev2=0;
        for(int i=start;i<end;i++){
            int temp=Math.max(prev1,prev2+nums[i]);
            prev2=prev1;
            prev1=temp;
        }
        return prev1;
    }
}
