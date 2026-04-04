class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
     int dup=0;
     sort(nums.begin(),nums.end());
     for(int i=1;i<nums.size();i++){
        if(nums[i]==nums[i-1]){
            dup=1;
            break;
        }
     }
     if(dup==1)return true;
     else return false;
    }
};
