class Solution {
public:
    bool isPalindrome(string s) {
        int l=0,r=s.size()-1;
        transform(s.begin(), s.end(), s.begin(),::toupper);
        while(l<=r){
            if(!isalnum(s[l])) {l++;continue;};
            if(!isalnum(s[r])){r--;continue;}
            if((s[l])!=(s[r])) return false;
            l++;
            r--;
        }
        return true;
    }
};
