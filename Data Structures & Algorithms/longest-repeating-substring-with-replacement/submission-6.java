class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int []arr=new int[26];
        int max_count=0;
        int l=0;
        int max_len=0;
        for(int r=0;r<n;r++){
            char chr=s.charAt(r);
            arr[s.charAt(r)-'A']++;
            max_count=Math.max(max_count,arr[s.charAt(r)-'A']);
            while((r-l+1)-max_count>k){
                arr[s.charAt(l)-'A']--;
                l++;
                
            }
            max_len=Math.max(max_len,r-l+1);
        }
        return max_len;
    }
}
