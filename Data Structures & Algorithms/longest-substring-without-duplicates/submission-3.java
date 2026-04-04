class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty())return 0;
        Set<Character>st=new HashSet<>();
        int l=0,r=0;
        int max_length=1;
        while(r<s.length()){
            while(st.contains(s.charAt(r))){
                st.remove(s.charAt(l));
                l++;
            }
            st.add(s.charAt(r));
            max_length=Math.max(max_length,r-l+1);
            r++;
        }  
        return  max_length;
    }
}
