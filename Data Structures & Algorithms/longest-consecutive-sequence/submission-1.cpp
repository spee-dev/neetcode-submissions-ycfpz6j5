class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        if(nums.size()==0)return 0;
        int last_number=INT_MIN;
        int max_count=0;
        int count=0;
        sort(nums.begin(),nums.end());
        for(int i=0;i<nums.size();i++){
            if(last_number==nums[i]-1){
                count++;
                last_number=nums[i];
            }
            else if(last_number<nums[i]){
                last_number=nums[i];
                count=1;
            }
            max_count=max(max_count,count);
        }
        return max_count;
    }
};
