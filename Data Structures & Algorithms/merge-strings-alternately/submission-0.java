class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb=new StringBuilder();
        boolean flag=true;
        int i=0,j=0;
        while(i<word1.length() && j<word2.length()){
            if(flag){
                sb.append(word1.charAt(i));
                i++;
                flag=!flag;
            }
            else{
                sb.append(word2.charAt(j));
                j++;
                flag=!flag;
            }
        }
        while(i<word1.length()){
            sb.append(word1.charAt(i));
            i++;
        }
        while(j<word2.length()){
            sb.append(word2.charAt(j));
            j++;
        }
        return sb.toString();
    }
}