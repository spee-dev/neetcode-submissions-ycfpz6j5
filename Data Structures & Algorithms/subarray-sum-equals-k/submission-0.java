class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer>mp=new HashMap<>();
        int count =0;
        int currSum=0;
        mp.put(currSum,1);
        for(int i=0;i<nums.length;i++){
              currSum+=nums[i];
              int diff=currSum-k;
              if(mp.containsKey(diff)){
                count+=mp.get(diff);
              }
              mp.put(currSum,mp.getOrDefault(currSum,0)+1);
        }
        return count;
    }
}