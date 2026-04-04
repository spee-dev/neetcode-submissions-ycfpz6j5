class Solution {
public:
    int maxArea(vector<int>& heights) {
        int l=0,r=heights.size()-1;
        int max_p=0;
        while(l<=r){
            int area=min(heights[l],heights[r])*(r-l);
            max_p=max(max_p,area);
            if(heights[l]<heights[r])l++;
            else r--;
        }
        return max_p;
    }
};
