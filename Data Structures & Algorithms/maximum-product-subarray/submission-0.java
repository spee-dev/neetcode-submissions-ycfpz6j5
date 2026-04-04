class Solution {
    public int maxProduct(int[] nums) {
       int n=nums.length;
       int res=Integer.MIN_VALUE;
       for(int i:nums){
           res=Math.max(res,i);
       } 
       int max_p=1;
       int min_p=1;
       for(int i:nums){
          int temp=max_p*i;
          max_p=Math.max(i,Math.max(max_p*i,min_p*i));
          min_p=Math.min(Math.min(temp,i*min_p),i);
          res=Math.max(res,max_p);
       }
       return res;
    }
}
