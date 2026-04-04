class Solution {
    public int[] productExceptSelf(int[] nums) {
       int lp=1,rp=1;
       int []ans=new int[nums.length];
       for(int i=0;i<nums.length;i++){
        ans[i]=lp;
        lp*=nums[i];
       } 
       for(int i=nums.length-1;i>=0;i--){
        ans[i]*=rp;
        rp*=nums[i];
       }
       return ans;
    }
}  
