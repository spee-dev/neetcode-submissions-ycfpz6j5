class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        unordered_map<int,int>mp;
        int i=0,dif;
        while(i<numbers.size()){
            dif=target-numbers[i];
            if(mp.count(dif))return {mp[dif],i+1};
            mp[numbers[i]]=i+1;
            i++;
        }
        return {};
    }
};
