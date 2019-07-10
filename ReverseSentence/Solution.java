public class Solution{
    public String ReverseSentence(String str){
        if(str.trim().equals(""))   return str;
        // 空格切割
        String[] a =str.split(" ");
        StringBuffer o = new StringBuffer();
        for(int i=a.length; i>0; i--){
            o.append(a[i-1]);
            if(i>1){
                o.append(" ");
            }
        }
        return o.toString();
    }
}