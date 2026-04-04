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
            for(int j=0;j<sz;j++){
            String wor=qu.poll();
            if(wor.equals(endWord))return step;
            char[] chars=wor.toCharArray();
            for(int i=0;i<chars.length;i++){
                char org=chars[i];
                for(char c='a';c<='z';c++){
                    chars[i]=c;
                    String news=new String(chars);
                    if(st.contains(news)){
                        qu.offer(news);
                        st.remove(news);
                    }  
                }
                chars[i]=org;
            }
            }
            step++;
        }
        return 0;
    }
}
