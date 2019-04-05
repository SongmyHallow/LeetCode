package ReverseInteger;

public class MySolution {
    public int reverse(int x) {
        
        if(x==0) {
            return 0;
        }
        
        int sol = 0;
        int length = String.valueOf(Math.abs(x)).length()-1;
        System.out.println(length);
        while(x!=0) {
            int a = x%10;
            sol += a * Math.pow(10,length);            
            System.out.println(a);
            x /= 10;
            length--;
        }
        System.out.println(sol);
        if(sol>=Integer.MAX_VALUE || -sol<=Integer.MIN_VALUE)  return 0;
        else if(x>=0)               return sol;
        else                        return -sol;
    }
}
