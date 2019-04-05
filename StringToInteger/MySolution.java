package StringToInteger;

public class MySolution {
    public int myAtoi(String str) {
        //special cases. empty string
        if(str.length()==0 || str.trim().isEmpty())  return 0;
        // remove spaces
        str = str.trim();
        char[] characters = str.toCharArray();
        
        int ascii = (int)characters[0];
        boolean flag = false;
        // tell if there is a sign in the string
        if(ascii==43 || ascii==45 || (ascii>47 && ascii<58)) {
            // '+' or '-'
            if(ascii==43 || ascii==45) {
                // in case there is only a sign in the string
                if(characters.length>1 && (int)(characters[1])>47 && (int)(characters[1])<58) {
                    flag=true;
                }
            }
            else {
                flag=true;
            }
        }
        // has special cases
        if(!flag)   return 0;
        // positive or negative
        int i = 0;
        char sign = '+';
        if(characters[0]=='+' || characters[0]=='-') {
            i=1;
            sign=characters[0];
        }
        // add the numerical part
        StringBuilder sb = new StringBuilder();
        while(i<=str.length()-1 && (int)(characters[i])>47 && (int)(characters[i])<58)
        {
            sb.append(characters[i]);
            i++;
        }
        // transfer to String array
        String number = sb.toString();
        // to char array
        char[] numerics = number.toCharArray();
        // use power to calculate the result according to digit
        int power=0;
        long num = 0;
        for(int j=number.length()-1;j>=0;j--)
        {
            num = num+((int)(Character.getNumericValue(numerics[j])*Math.pow(10, power)));
            power++;
        }
        
        if(sign=='-')   num=num*-1;
        if(num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        
        return (int)num;
        
    }
}
