import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or 
 * blue, sort them in-place so that objects of the same 
 * color are adjacent, with the colors in the order red, 
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent 
 * the color red, white, and blue respectively.
 */
public class Solution{
    public void sortColors(int[] nums){
        for(int i=0; i<nums.length; i++){
            int temp = nums[i];
            for(int j=i; j>=0; j--){
              if(j>0 && nums[j-1]>temp){
                nums[j] = nums[j-1];
              }
              else{
                nums[j] = temp;
                break;
              }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        Solution sol = new Solution();
        sol.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}