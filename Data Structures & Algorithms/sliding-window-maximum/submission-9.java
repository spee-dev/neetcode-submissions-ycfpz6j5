class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer>dq=new LinkedList<>();
        int []ans=new int[n-k+1];
        for(int i=0;i<nums.length;i++){
            if(!dq.isEmpty() && dq.peekFirst()<i-k+1){
                dq.pollFirst();
            }
          
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1){
               ans[i-k+1]=nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}
