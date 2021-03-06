import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a sorted array nums, remove the duplicates in-place 
 * such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this 
 * by modifying the input array in-place with O(1) extra memory.
 */
public class Solution{
    public int removeDuplicates(int[] nums){
        if(nums.length==0)  return 0;
        int i=0;
        for(int j=1; j<nums.length; j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,3,7,9};
        Solution sol = new Solution();
        System.out.println(sol.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}