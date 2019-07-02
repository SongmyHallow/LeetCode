package NumberOf1Between1AndN;

public class solution{
    public int NumberOf1Between1AndN(int n){
        if(n<=0)    return 0;
        int count = 0;
        for(long i=1; i<=n; i*=10){
            long divider = i*10;
            long k = n%divider;
            count += (n/divider)*i;
            if(k > i*2-1) count += i;
            else if(k < i)  count += 0;
            else    count += (k-i+1);
        }
        return count;
    }
}