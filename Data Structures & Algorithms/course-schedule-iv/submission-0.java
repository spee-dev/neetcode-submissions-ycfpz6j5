class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
       boolean [][]isPre=new boolean[numCourses][numCourses];
       for(int i=0;i<numCourses;i++){
         for(int j=0;j<numCourses;j++){
            isPre[i][j]=false;
         }
       }    
       for(int []pre:prerequisites){
        int u=pre[0];
        int v=pre[1];
        isPre[u][v]=true;
       }
       for(int k=0;k<numCourses;k++){
          for (int i=0;i<numCourses;i++){
            for(int j=0;j<numCourses;j++){
                if (isPre[i][k] && isPre[k][j]) isPre[i][j]=true;
            }
          }
       }
       List<Boolean>ans=new ArrayList<>();
       for(int[]qu:queries){
         int u=qu[0];
         int v=qu[1];
         if(isPre[u][v])ans.add(true);
         else ans.add(false);
       }
       return ans;
    }
}