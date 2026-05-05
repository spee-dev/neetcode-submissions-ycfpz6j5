class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n=nums.length;
        Set<Integer>st=new HashSet<>();
        for(int i=0;i<n;i++){
            if(st.contains(nums[i]))return true;
            st.add(nums[i]);
        } 
        return false;
    }
}
