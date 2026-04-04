class Solution {
    public int characterReplacement(String s, int k) {
        int []arr=new int[26];
        int max_count=0;
        int max_length=0;
        int l=0;
        for(int r=0;r<s.length();r++){
            arr[s.charAt(r)-'A']++;
            max_count=Math.max(max_count,arr[s.charAt(r)-'A']);
            while((r-l+1)-max_count>k){
                arr[s.charAt(l)-'A']--;
                l++;
            }
            max_length=Math.max(r-l+1,max_length);
            
        }
        return max_length;
    }
}
