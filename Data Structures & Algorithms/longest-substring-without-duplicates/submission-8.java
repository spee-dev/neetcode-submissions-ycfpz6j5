class Solution {
    public int lengthOfLongestSubstring(String s) {
       int n=s.length();
       int max_len=0;
       int l=0;
       int r=0;
       Set<Character>st=new HashSet<>();
       while(r<n){
         char chr=s.charAt(r);
         while(st.contains(chr)){
            char chl=s.charAt(l);
            st.remove(chl);
            l++;
         }
         max_len=Math.max(max_len,r-l+1);
         st.add(chr);
         r++;
       } 
       return max_len;
    }
}
