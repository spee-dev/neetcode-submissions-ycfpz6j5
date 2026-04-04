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
                String  word=qu.poll();
                if(word.equals(endWord))return step;
                char[] chars=word.toCharArray();
                for(int j=0;j<chars.length;j++){
                    char orc=chars[j];

                    for(char c='a';c<='z';c++){
                        chars[j]=c;
                        String newW=new String(chars);
                        if(st.contains(newW)){
                            qu.offer(newW);
                            st.remove(newW);
                        }
                    }
                    chars[j]=orc;
                }
            }
            step++;
        }
        return 0;
    }
}
