class Solution {
public:
    bool isValid(string s) {
        if(s.length()<=1)return false;
          char st[s.length()+1];
          int index=0;
          for(int i=0;i<s.length();i++){
            if(s[i]=='('||s[i]=='{'||s[i]=='[')
                st[index++]=s[i];
            else if(index!=0){
                if((s[i]==')'&&st[index-1]=='(')||(s[i]=='}'&&st[index-1]=='{')||(s[i]==']'&&st[index-1]=='[')){
                    index--;
                }
                else{
                    st[index++]=s[i];
                }
            }
            else{
                st[index++]=s[i];
            }
          }
          return index==0;
    }
};
