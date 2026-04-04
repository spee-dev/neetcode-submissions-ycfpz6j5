class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       
        List<List<Integer>>adjl=new ArrayList<>();
        int []indg=new int [numCourses];
        for(int i=0;i<numCourses;i++){
            adjl.add(new ArrayList<>());
        }
        for(int []pre:prerequisites){
            int u=pre[0];
            int v=pre[1];
            adjl.get(v).add(u);
            indg[u]++;
        }
        Queue<Integer>qu=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indg[i]==0){
                qu.add(i);
            }
        }
        int j=0;
        int ans[]=new int[numCourses];
        while(!qu.isEmpty()){
            int curr=qu.poll();
            ans[j++]=curr;
            for(Integer it:adjl.get(curr)){
                indg[it]--;
                if(indg[it]==0){
                    qu.add(it);
                }
            }
        }
        if(j!=numCourses)return new int[0];
        return ans;
    }
}
        
 
