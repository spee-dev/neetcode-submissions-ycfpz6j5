class Solution {
    public int maxSubArray(int[] nums) {
        int currS=nums[0];
        int maxS=nums[0];
        for(int i=1;i<nums.length;i++){
            currS=Math.max(currS+nums[i],nums[i]);
            maxS=Math.max(currS,maxS);
        }
        return maxS;
    }

}
