class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String>ws=new HashSet<>(wordList);
        if(!ws.contains(endWord)) return 0;
        Queue<String>qu=new LinkedList<>();
        qu.offer(beginWord);
        ws.remove(beginWord);
        int step=1;
        while(!qu.isEmpty()){
            int sz=qu.size();
            for(int i=0;i<sz;i++){
                String news=qu.poll();
                if(news.equals(endWord))return step;
                char[]chars=news.toCharArray();
                for(int j=0;j<chars.length;j++){
                    char org=chars[j];
                    for(char c='a';c<='z';c++){
                        chars[j]=c;
                        String newss=new String(chars);
                        if(ws.contains(newss)){
                            qu.offer(newss);
                            ws.remove(newss);
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
