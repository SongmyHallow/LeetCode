// Reverse bits of a given 32 bits unsigned integer.
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if(n==0)
            return 0;
        int result = 0;
        for(int i=0; i<32; i++){
            // 结果从右开始生成
            result <<= 1;
            // 最后一位是1
            if((n&1) == 1)
                result++;
            // n向右移动
            n >>= 1;
        }
        return result;
    }
}