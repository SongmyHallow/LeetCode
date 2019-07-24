import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, 
 * you need to find the total number of continuous 
 * subarrays whose sum equals to k.
 */
public class Solution{
    /**
     * If the cumulative sum(repreesnted by sum[i]sum[i] for sum 
     * upto i^{th}i  th index) upto two indices is the same, the 
     * sum of the elements lying in between those indices is zero. 
     */
    public int subarraySum(int[] nums, int k){
        int count = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum-k))
                count+=map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        Solution sol = new Solution();
        System.out.println(sol.subarraySum(nums, k));
    }
}