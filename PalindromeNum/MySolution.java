package PalindromeNum;

public class MySolution {
    public boolean isPalindrome(int x) {
        if(x<0) {
            return false;
        }
        if(x==0) {
            return true;
        }
        int oriValue = x;
        long sol = 0;
        int length = String.valueOf(x).length()-1;
        while(x!=0) {
            int a = x%10;
            sol += a * Math.pow(10,length);            
            x /= 10;
            length--;
        }
        System.out.println(sol);
       if(sol == oriValue)  return true;
       else                 return false;
    }
}
