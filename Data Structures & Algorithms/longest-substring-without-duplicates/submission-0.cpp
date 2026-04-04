class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n=s.size();
        if(n==0)return 0;
        int l=0,r=0,max_i=1;
        unordered_map<char,int>mp;
        while(r<n){
            if(mp.find(s[r])!=mp.end()&&mp[s[r]]>=l){
                l=mp[s[r]]+1;
            }
            max_i=max(max_i,r-l+1);
            mp[s[r]]=r;
            r++;
        }
        return max_i;
    }
};
