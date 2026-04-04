class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
       int ans[]=new int[n-k+1];
       Deque<Integer>qu=new LinkedList<>();
       for(int i=0;i<nums.length;i++){
            if(!qu.isEmpty() && qu.peekFirst()<i-k+1){
                qu.pollFirst();
            }
            while(!qu.isEmpty() && nums[qu.peekLast()]<nums[i]){
                qu.pollLast();
            }
            qu.offer(i);
            if(i>=k-1){
                ans[i-k+1]=nums[qu.peekFirst()];
            }
       } 
       return ans;
    }
}
