package match;
public class Solution{
    // 需要时刻检验数组边界
    public boolean match(char[] str, char[] pattern){
        if(str == null || pattern == null){
            return false;
        }

        int strIndex = 0;
        int patternIndex = 0;
        return match_support(str, strIndex, pattern, patternIndex);
    }

    private boolean match_support(char[] str, int strIndex, char[] pattern,int patternIndex){
        if(strIndex == str.length && patternIndex == pattern.length){
            return true;
        }
        // pattern 先结束匹配说明false
        if(strIndex != str.length && patternIndex == pattern.length){
            return false;
        }
        // 下一位是*，且字符串第一个跟模式第一个匹配，分三种匹配
        // 不匹配，模式后移
        if(patternIndex+1 < pattern.length && pattern[patternIndex+1] == '*'){
            if((strIndex != str.length && pattern[patternIndex]==str[strIndex])||(strIndex!=str.length && pattern[patternIndex]=='.')){
                // 1. 模式后移两位，视为x*匹配0个字符
                // 2. 视为模式匹配1个字符
                // 3. *匹配1个，再匹配str中的下一个
                return match_support(str, strIndex, pattern, patternIndex+2)||match_support(str, strIndex+1, pattern, patternIndex+1)||match_support(str, strIndex+1, pattern, patternIndex);  
            }
            else{
                return match_support(str, strIndex, pattern, patternIndex+2);
            }
        }

        // 模式第二个不是*，且字符串第一个跟模式第一个匹配，则都后移一位
        if((strIndex!=str.length && pattern[patternIndex]==str[strIndex])||(strIndex != str.length && pattern[patternIndex]=='.')){
            return match_support(str, strIndex+1, patvtern, patternIndex+1);
        }
        return false;
    }
}
