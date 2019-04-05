package PowerInt;

public class MySolution {
    public double Power(double base, int exponent) {
        
        if(exponent == 0)   return 1;
        if(exponent == 1)   return base;
        if(exponent == -1)  return 1/base;
        
        if(exponent > 0) {
            return base * Power(base, exponent-1);
        }
        else {
            return 1/base * Power(base, exponent+1);
        }
        
    }
}
