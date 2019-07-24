import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of non-negative numbers and a target integer k, 
 * write a function to check if the array has a continuous subarray
 * of size at least 2 that sums up to a multiple of k, that is, 
 * sums up to n*k where n is also an integer.
 */
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k){
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            if(k!=0)    sum%=k;
            Integer prev = map.get(sum);
            if(prev!=null){
                // size >= 2
                if(i-prev > 1)  return true;
            }
            else{
                map.put(sum, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0,0};
        int k = 0;
        Solution sol = new Solution();
        System.out.println(sol.checkSubarraySum(nums, k));
    }
}