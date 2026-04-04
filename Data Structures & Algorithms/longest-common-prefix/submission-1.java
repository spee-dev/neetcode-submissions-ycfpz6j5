class Solution {
    public String longestCommonPrefix(String[] strs) {
         if (strs.length==0)return "";
          StringBuilder ans=new StringBuilder();
          int n=Integer.MAX_VALUE;
          for(String str:strs){
            n=Math.min(n,str.length());
          }
          
            for(int j=0;j<n;j++){
                char c=strs[0].charAt(j);
                for(int i=1;i<strs.length;i++){
                     if(strs[i].charAt(j)!=c)return ans.toString();
                }
                ans.append(c);
            }
          return ans.toString();
    }
}