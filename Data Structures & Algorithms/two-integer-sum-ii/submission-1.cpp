class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int l=0,r=nums.size()-1;
        int sum=0;
        while(l<r){
            
            if(target==nums[l]+nums[r]){
                return {l+1,r+1};
            }
            else if(target<nums[l]+nums[r])r--;
            else l++;
        }
        return{};
    }
};
