class Solution {
    
    public int minEatingSpeed(int[] piles, int h) {
      int l=1;
      int r=Integer.MIN_VALUE;
      int ans;
      for(int i:piles){
        r=Math.max(i,r);
      }  
      ans=r;
      while(l<=r){
        int mid=l+(r-l)/2;
         long totalTime = 0;
            for (int p : piles) {
                totalTime += Math.ceil((double) p / mid);
            }
        if(totalTime<=h){
            ans=mid;
            r=mid-1;
        }
        else{
            l=mid+1;
        }

      }
      return ans;
    }
}
