class Solution {
    public int maxArea(int[] height) {
       int n=height.length;
       int l=0,r=n-1;
       int max_a=0;
       while(l<r){
        int area=Math.min(height[l],height[r])*(r-l);
        if(height[l]<height[r])l++;
        else r--;
        max_a=Math.max(area,max_a);
       }
       return max_a; 
    }
}
