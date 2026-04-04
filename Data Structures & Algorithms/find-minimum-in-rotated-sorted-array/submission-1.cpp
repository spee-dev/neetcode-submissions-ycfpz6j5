class Solution {
public:
    int findMin(vector<int> &nums) {
        if(nums.size()==1)return nums[0];
        if(nums.size()==0)return 0;
        int l=0,r=nums.size()-1;
        int min_f=INT_MAX;
        while(l<r){
            if(nums[l]<nums[r]){
                min_f=min(min_f,nums[l]);
                r--;
            }
            else{
                min_f=min(min_f,nums[r]);
                l++;
            }
        }
        return min_f;
    }
};
