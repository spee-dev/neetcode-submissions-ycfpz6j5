class Solution {
    boolean dfs(int node ,ArrayList<ArrayList<Integer>>adjl,boolean[] visit,boolean[]recurs){
        visit[node]=true;
        recurs[node]=true;
        for(Integer it: adjl.get(node)){
            if(visit[it]==false){
               if(dfs(it,adjl,visit,recurs))return true;
            }
            else if(recurs[it]==true)return true;
        }
        recurs[node]=false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adjl=new ArrayList<ArrayList<Integer>>();
        boolean[] visit=new boolean[numCourses];
        boolean[] recurs=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            adjl.add(new ArrayList<>());
        }
        for(int[] ede:prerequisites){
            int course=ede[0];
            int pre=ede[1];
            adjl.get(pre).add(course);
        }
        for(int i=0;i<numCourses;i++){
            if(visit[i]==false){
                if(dfs(i,adjl,visit,recurs)){
                    return false;
                }
            }
        }
        return true;
    }
}
