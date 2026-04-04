class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer>st=new HashSet<>();
        for(int i:nums)st.add(i);
        int max_Len=0;
        for(int i:nums){
            int currN=i;
            int currLen=1;
            if(!st.contains(i-1)){
            
            while(st.contains(currN+1)){
                currN+=1;
                currLen+=1;
            }
            }
            max_Len=Math.max(max_Len,currLen);
        }
        return max_Len;
    }
}
