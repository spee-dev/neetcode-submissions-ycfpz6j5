class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n=nums1.size()+nums2.size();
        vector<int>ans;
        int l=0,r=0,k=0;
        while(l<nums1.size() && r<nums2.size()){
        if(nums1[l]<nums2[r]){
            ans.push_back(nums1[l]);
            l++;
        }
        else{
            ans.push_back(nums2[r]);
            r++;
        }
        }
        while(l<nums1.size()){
            ans.push_back(nums1[l]);
            l++;
        }
        while(r<nums2.size()){
            ans.push_back(nums2[r]);
            r++;
        }
        if(ans.size()%2==0){
            return double (ans[n/2]+ans[(n/2)-1])/2;
        }
        else
          return ans[n/2];
    }
};
