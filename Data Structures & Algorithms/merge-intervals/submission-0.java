class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]>ans=new ArrayList<>();
        ans.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int []currentIntervals=intervals[i];
            int []lastInterval=ans.get(ans.size()-1);
            if(currentIntervals[0]<=lastInterval[1]){
                lastInterval[1]=Math.max(currentIntervals[1],lastInterval[1]);

            }
            else{
                ans.add(currentIntervals);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
