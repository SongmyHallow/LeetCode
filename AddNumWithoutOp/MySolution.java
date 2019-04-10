package AddNumWithoutOp;

public class MySolution {
    public int Add(int num1,int num2) {
        if(num2 == 0)	return num1;
        if(num1 == 0)	return num2;
        int sum = num1 ^ num2;
        int carry = (num1 & num2) << 1;
        return Add(sum, carry);
    }
}
