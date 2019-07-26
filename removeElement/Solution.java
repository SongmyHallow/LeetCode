import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums and a value val, 
 * remove all instances of that value in-place and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this 
 * by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you 
 * leave beyond the new length.
 */
public class Solution{
    public int removeElement(int[] nums, int val){
        if(nums.length==0)  return 0;
        int i = 0;
        for(int j=0; j<nums.length;j++){
            if(nums[j]!=val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        Solution sol = new Solution();
        System.out.println(sol.removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }
}