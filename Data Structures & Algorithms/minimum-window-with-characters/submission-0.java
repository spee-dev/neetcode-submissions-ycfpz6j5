class Solution {
    public String minWindow(String s, String t) {
         int n=s.length();
         int m=t.length();
         int minlen=Integer.MAX_VALUE;
         int stI=-1;
         int l=0,r=0;
         int []freq=new int[256];
         int count=0;
         for(char c: t.toCharArray()){
            freq[c]++;
         }
         while(r<n){
            char rc=s.charAt(r);
            if(freq[rc]>0){
                count++;
            }
            freq[rc]--;
            while(count==m){
                if(r-l+1<minlen){
                    minlen=r-l+1;
                    stI=l;
                }
                char lc=s.charAt(l);
                freq[lc]++;
                if(freq[lc]>0){
                    count--;
                }
                l++;
            }
            r++;
         }
         return (minlen==Integer.MAX_VALUE?"":s.substring(stI,stI+minlen));
    }
}
