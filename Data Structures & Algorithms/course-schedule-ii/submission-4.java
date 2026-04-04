class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adjl=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<numCourses;i++){
            adjl.add(new ArrayList<>());
        }
         int []indeg=new int[numCourses];
        for(int []ed:prerequisites){
            adjl.get(ed[1]).add(ed[0]);
            indeg[ed[0]]++;
        }
       
        boolean[]vis=new boolean[numCourses];
        Queue<Integer>qu=new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                qu.offer(i);
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();

        while(!qu.isEmpty()){
            int curr=qu.poll();
            ans.add(curr);
            for(Integer it:adjl.get(curr)){
                indeg[it]--;
                if(indeg[it]==0)qu.offer(it);
            }
        }
        if(ans.size()!=numCourses)return new int[0];
        int[] order=new int[numCourses];
        int in=0;
        for(Integer it:ans ) order[in++]=it;
        return order;
    }
}
