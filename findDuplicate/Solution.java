import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums containing n + 1 integers where each integer 
 * is between 1 and n (inclusive), prove that at least one 
 * duplicate number must exist. Assume that there is only one 
 * duplicate number, find the duplicate one.
 */
class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }
            else{
                ans = nums[i];
            }
        }
        return ans;
    }
}