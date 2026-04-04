class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
       if(n==1)return cost[0];
       if(n==2)return Math.min(cost[0],cost[1]);
       int prev2=cost[0];
       int prev1=cost[1];
       for(int i=2;i<n;i++){
             int temp=prev1;
             prev1=Math.min(cost[i]+prev1,cost[i]+prev2);
             prev2=temp;
       } 
       return Math.min(prev1,prev2);
    }
}
