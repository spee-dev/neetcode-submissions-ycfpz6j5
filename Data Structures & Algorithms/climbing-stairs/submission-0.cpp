class Solution {
public:
    int climbStairs(int n) {
        int prev1=0;
        int prev=1;
        int curr;
        for(int i=1;i<=n;i++){
            curr=prev1+prev;
            prev1=prev;
            prev=curr;
        }
        return prev;
    }
};
