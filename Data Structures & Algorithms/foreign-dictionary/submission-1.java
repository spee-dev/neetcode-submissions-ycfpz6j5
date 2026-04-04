class Solution {
    public ArrayList<Integer>topo(int V,ArrayList<ArrayList<Integer>>adjl,boolean [] present){
        int [] indg=new int[26];
        for(int u=0;u<26;u++){
            for(Integer v:adjl.get(u)){
                indg[v]++;
            }
        }
        Queue<Integer>qu=new LinkedList<>();
        for(int i=0;i<26;i++){
            if(present[i] && indg[i]==0){
                qu.offer(i);
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        while(!qu.isEmpty()){
            int curr=qu.poll();
            ans.add(curr);
            for(Integer it:adjl.get(curr)){
                indg[it]--;
                if(indg[it]==0){
                    qu.offer(it);
                }
            }
        }
        int top=0;
        for(boolean p:present){
            if(p)top++;
        }
        if(top!=ans.size())return new ArrayList<>();

        return ans;
    }
    public String foreignDictionary(String[] words) {
      ArrayList<ArrayList<Integer>>adjl=new ArrayList<>();
      for(int i=0;i<26;i++){
        adjl.add(new ArrayList<>());
      }
      boolean[]present=new boolean[26];
      for(String word:words){
        for(char c:word.toCharArray()){
            present[c-'a']=true;
        }
      }
      for(int i=0;i<words.length-1;i++){
        String str1=words[i];
        String str2=words[i+1];
        int len=Math.min(str1.length(),str2.length());
        boolean found=false;
        for(int j=0;j<len;j++){
            if(str1.charAt(j)!=str2.charAt(j)){
                adjl.get(str1.charAt(j)-'a').add(str2.charAt(j)-'a');
                found=true;
                break;
            }
        }
        if(found==false && str1.length()>str2.length())return "";
      }
      ArrayList<Integer>ans=topo(26,adjl,present);
        if(ans.isEmpty())return "";
        StringBuilder st=new StringBuilder();
        for(Integer it:ans){
            st.append((char)(it + 'a'));
        }
        return st.toString();
    }
}
