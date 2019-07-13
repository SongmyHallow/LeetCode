public class Solution{
  public int StrToInt(String str){
      boolean flag = false;
      if(str == null | str.trim().equals("")){
        flag = true;
        return 0;
      }

      // symbol = 0, positive; symbol = 1, negative
      int symbol = 0;
      // if the first position is sign
      int sign = 0;
      char[] chars = str.trim().toCharArray();
      if(chars[0] == '+'){
        sign = 1;
      }
      else if(chars[0] == '-'){
        sign = 1;
        symbol = 1;
      }

      int result = 0;
      for(int i=sign; i<chars.length; i++){
        // illegal char
        if(chars[i] > '9' || chars[i] < '0'){
          flag = true;
          return 0;
        }
        int sum = result * 10 + (int)(chars[i] - '0');
        // overflow
        if((sum - (int)(chars[i]-'0'))/10 != result){
          flag = true;
          return 0;
        }
        result = result * 10 + (int)(chars[i] - '0');
      }
      // when value=-2147483648，value=-value
      result = (int)Math.pow(-1, symbol) * result;
      return result;
  }
}