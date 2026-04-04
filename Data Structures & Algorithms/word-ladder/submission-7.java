class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String>st=new HashSet<>(wordList);
        if(!st.contains(endWord))return 0;
        Queue<String>qu=new LinkedList<>();
        qu.offer(beginWord);
        st.remove(beginWord);
        int step=1;
        while(!qu.isEmpty()){
            int sz=qu.size();
            
            for(int i=0;i<sz;i++){
                String wr=qu.poll();
                if(wr.equals(endWord))return step;
                char[]chars=wr.toCharArray();
                for(int j=0;j<chars.length;j++){
                    char org=chars[j];
                    for(char c='a';c<='z';c++){
                        chars[j]=c;
                        String neww=new String(chars);
                        if(st.contains(neww)){
                            qu.offer(neww);
                            st.remove(neww);
                        }
                    }
                    chars[j]=org;
                }
            }
            step++;
        }
        return 0;
    }
}
