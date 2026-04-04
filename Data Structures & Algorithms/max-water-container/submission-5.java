class Solution {
    public int maxArea(int[] heights) {
        int n=heights.length;
        int max_area=Integer.MIN_VALUE;
        int l=0,r=n-1;
        while(l<r){
            int he=Math.min(heights[l],heights[r]);
            int w=r-l;
            max_area=Math.max(max_area,he*w);
            if(heights[l]<heights[r])l++;
            else r--;

        }
        return max_area;
    }
}
