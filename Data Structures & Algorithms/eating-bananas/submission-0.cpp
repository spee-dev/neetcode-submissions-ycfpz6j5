class Solution {
public:
  bool feasible(int k,vector<int>&p,int h){
    int t_h=0;
    for(int i:p){
        t_h+=ceil(1.0*i/k);
    }
    return t_h<=h;
  } 
    int minEatingSpeed(vector<int>& piles, int h) {
        int l=1,r=1000000000;
        while(l<r){
            int mid=l+(r-l)/2;
            if(feasible(mid,piles, h)){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
};
