package isNumeric;
public class Solution{
    /**
     * 1. 不能出现连续符号
     * 2. e之前有内容，之后有内容且没有小数点
     * 3. 小数点不能多于1个
     */
    public boolean isNumeric(char[] str){
        if(str==null || str.length==0){
            return false;
        }
        boolean sign = false, decimal = false, hasE = false;
        for(int i=0; i<str.length; i++){
            if(str[i]=='e' || str[i]=='E'){
                if(i==str.length-1) return false;
                if(hasE)    return false;
                hasE = true;
            }
            else if(str[i]=='+' || str[i]=='-'){
                if(sign && str[i-1]!='e' && str[i-1]!='E')  return false;
                // 第一次有正负号，不在开头则须在e后
                if(!sign && i>0 && str[i-1]!='e' && str[i-1]!='E')   return false;
                sign = true;
            }
            else if(str[i]=='.'){
                // e后面没有小数点，小数点不能有两个
                if(hasE || decimal) return false;
                decimal = true;
            }
            else if(str[i]<'0' || str[i]>'9')   return false;
        }
        return true;
        
    }
}