class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer,Integer>mp=new HashMap<>();
       for(Integer it:nums){
        mp.put(it,mp.getOrDefault(it,0)+1);
       } 
       PriorityQueue<Map.Entry<Integer,Integer>>pq=new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
       for(Map.Entry<Integer,Integer>entry:mp.entrySet()){
           pq.offer(entry);
           if(pq.size()>k){
              pq.poll();
           }
       }
       int []ans=new int[k];
       int i=0;
       while(!pq.isEmpty()){
            ans[i++]=pq.poll().getKey();
            
       }
       return ans;
    }
}
