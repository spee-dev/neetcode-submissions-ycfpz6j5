class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adjl=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjl.add(new ArrayList<>());
        }
        int []indegree=new int[numCourses];
        for(int []ed:prerequisites){
            adjl.get(ed[1]).add(ed[0]);
            indegree[ed[0]]++;
        }
        Queue<Integer>qu=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                qu.offer(i);
            }
        }
        List<Integer>ans=new ArrayList<>();
        while(!qu.isEmpty()){
           int c=qu.poll();
           ans.add(c);
           for(Integer it:adjl.get(c)){
            indegree[it]--;
            if(indegree[it]==0){
                qu.offer(it);
            }
           }
        }
        if(ans.size()!=numCourses) return new int[0];
        int []order=new int[numCourses];
        int j=0;
        for(int i: ans){
            order[j++]=i;
        }
        return order;
    }
}
