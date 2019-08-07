import java.util.Arrays;

/**
 * Given an array, rotate the array to the right by k steps, 
 * where k is non-negative.
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] sol = new int[len];

        for(int i=0; i<nums.length; i++)
            sol[(i+k)%nums.length] = nums[i];
            
        for(int i=0; i<nums.length; i++)
            nums[i] = sol[i];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        Solution sol = new Solution();
        sol.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}