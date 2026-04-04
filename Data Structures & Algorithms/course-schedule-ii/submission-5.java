class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       ArrayList<ArrayList<Integer>>adjl=new ArrayList<>();
       for(int i=0;i<numCourses;i++){
        adjl.add(new ArrayList<>());
       }
       int inD[]=new int[numCourses];
       for(int []pre:prerequisites){
        adjl.get(pre[1]).add(pre[0]);
        inD[pre[0]]++;
       }
       Queue<Integer>qu=new LinkedList<>();
       for(int i=0;i<numCourses;i++){
        if(inD[i]==0)qu.offer(i);
       }
       ArrayList<Integer>ans=new ArrayList<>();
       while(!qu.isEmpty()){
           int course=qu.poll();
           ans.add(course);
           for(Integer it:adjl.get(course)){
              inD[it]--;
              if(inD[it]==0){
                qu.offer(it);
              }
           }
       }
       if(ans.size()!=numCourses)return new int[0];
       int []order=new int[numCourses];
       for(int i=0;i<ans.size();i++){
          order[i]=ans.get(i);
       }
       return order;
    }
}
