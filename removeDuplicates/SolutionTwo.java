import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a sorted array nums, remove the duplicates 
 * in-place such that duplicates appeared at most twice 
 * and return the new length.
 * Do not allocate extra space for another array, you must do 
 * this by modifying the input array in-place with O(1) extra memory.
 */
public class SolutionTwo{
    public int removeDuplicates(int[] nums){
        if(nums.length==0)  return 0;
        int i = 0;
        for(int n:nums){
            if(i<2 || n>nums[i-2])
                nums[i++] = n;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,7};
        SolutionTwo sol = new SolutionTwo();
        System.out.println(sol.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}