class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>mp=new HashMap<>();
        for(String str:strs){
            int []count=new int [26];
            for (char c:str.toCharArray()){
                count[c-'a']++;
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
