class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
          Map<String,List<String>>mp=new HashMap<>();
          for(String str:strs){
            int []count=new int[26];
            int n=str.length();
            for(int i=0;i<n;i++){
                count[str.charAt(i)-'a']++;
            }
            String key=Arrays.toString(count);
            if(!mp.containsKey(key)){
                mp.put(key,new ArrayList<>());
            }
            mp.get(key).add(str);
          }
          return new ArrayList<>(mp.values());
    }
}
