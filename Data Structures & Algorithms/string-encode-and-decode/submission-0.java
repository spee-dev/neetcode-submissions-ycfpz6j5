class Solution {

    public String encode(List<String> strs) {
         StringBuilder ans=new StringBuilder();
         for(String str:strs){
            ans.append(str.length()).append('#').append(str);
         }
         return ans.toString();
    }

    public List<String> decode(String str) {
      List<String> ans=new ArrayList<>();
      int i=0;
      while(i<str.length()){
        int j=i;
        while(str.charAt(j)!='#'){
            j++;
        }
        int len=Integer.parseInt(str.substring(i,j));
        i=j+1;
        String st=str.substring(i,i+len);
        ans.add(st);
        i=i+len;
        
      }
      return ans;
    }
}
