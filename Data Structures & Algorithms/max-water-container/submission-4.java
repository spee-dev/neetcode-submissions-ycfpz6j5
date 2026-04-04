class Solution {
    public int maxArea(int[] heights) {
        int l=0;
        int n=heights.length;
        int r=n-1;
        int max_ans=0;
        while(l<r){
            int height=Math.min(heights[l],heights[r]);
            int area=height*(r-l);
            max_ans=Math.max(area,max_ans);
            if(heights[l]<heights[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return max_ans;
    }
}
