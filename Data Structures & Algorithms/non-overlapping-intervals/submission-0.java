class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
         Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int count=0;
        List<int[]>ans=new ArrayList<>();
        ans.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int []curr=intervals[i];
            int []last=ans.get(ans.size()-1);
            if(curr[0]<last[1]){
                count++;
            }
            else{
                ans.add(intervals[i]);
            }
        } 
        return count;
    }
}
