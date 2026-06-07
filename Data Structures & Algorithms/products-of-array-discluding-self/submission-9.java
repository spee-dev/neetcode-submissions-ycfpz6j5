class Solution {
    public int[] productExceptSelf(int[] nums) {
        int []ans=new int[nums.length];
        int leftp=1;
        int rightp=1;
        for(int i=0;i<nums.length;i++){
            ans[i]=leftp;
            leftp=nums[i]*leftp;
        }
        for(int i=nums.length-1;i>=0;i--){
            ans[i]*=rightp;
            rightp=rightp*nums[i];
        }
        return ans;
    }
}  
