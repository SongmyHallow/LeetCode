package LeftRotateString;
public class Solution{
    public String LeftRotateString(String str, int n){
        if(str.length() == 0 || str == null)    return str;
        String str1 = str.substring(0, n);
        String str2 = str.substring(n, str.length());
        String sol = str2.concat(str1);
        return sol;
    }
}