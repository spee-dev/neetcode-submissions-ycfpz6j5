class Solution {
    public int maxProfit(int[] prices) {
      int max_p=0;
      int min_p=prices[0];
      for(int p:prices){
        if(p<min_p){
            min_p=p;
        }
        else{
            max_p=Math.max(max_p,p-min_p);
        }
      }
      return max_p;  
    }
}
