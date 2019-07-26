import java.util.Arrays;

/**
 * Given an array nums, write a function to move 
 * all 0's to the end of it while maintaining the 
 * relative order of the non-zero elements.
 */
public class Solution{
    public void moveZeroes(int[] nums){
        if(nums.length==0)  return;
        int i = 0;
        for(int j=0; j<nums.length; j++){
            if(nums[j]!=0){
                nums[i] = nums[j];
                if(i!=j)    nums[j] = 0;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        Solution sol = new Solution();
        sol.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}