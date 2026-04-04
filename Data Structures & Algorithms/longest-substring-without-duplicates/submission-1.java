class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n==0)return 0;
        int l=0,max_l=1;
        Map<Character,Integer>mp=new HashMap<>();
        for(int r=0;r<n;r++){
            char c=s.charAt(r);
            if(mp.containsKey(c)&&mp.get(c)>=l){
                l=mp.get(c)+1;
            }
            max_l=Math.max(max_l,r-l+1);
            mp.put(c,r);
            
        }
        return max_l;
    }
}
