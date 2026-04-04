class Solution {
    public int characterReplacement(String s, int k) {
        
        int []count=new int[26];
        int max_count=0;
        int l=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
              count[s.charAt(i)-'A']++;
              max_count=Math.max(max_count,count[s.charAt(i)-'A']);
             
              while((i-l+1)-max_count>k){
                  count[s.charAt(l)-'A']--;
                  l++;
              }
             ans=Math.max(ans,i-l+1);
        }
        return ans;
    }
}
