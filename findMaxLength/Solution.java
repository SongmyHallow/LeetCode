import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous 
 * subarray with equal number of 0 and 1.
 */
public class Solution{
    public int findMaxLength(int[] nums){
        int maxLength = 0;
        for(int start=0; start<nums.length;start++){
            int count_zero=0, count_one=0;
            for(int end=start; end<nums.length; end++){
                if(nums[end]==0)    count_zero++;
                else                count_one++;
                
                if(count_one==count_zero){
                    maxLength = Math.max(maxLength,end-start+1);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,0,0,0,1,1};
        Solution sol = new Solution();
        System.out.println(sol.findMaxLength(nums));
    }
}