import java.util.Arrays;

public class Solution_ExtraArray{
    /**
     * Use a variable to store the relative number of ones and zeros
     * encountered so far
     * 
     * Use arr to keep track of the various count's encountered so far
     * Whenever we come across the same count value later, we determine
     * the length of the subarray lying between the indices corresponding
     * to the same count values
     * 
     */
    public int findMaxLength(int[] nums){
        int[] arr = new int[2*nums.length+1];
        Arrays.fill(arr, -2);
        int maxLength = 0, count = 0;

        for(int i=0;i<nums.length;i++){
            count = count + (nums[i]==0 ? -1 : 1);
            if(arr[count+nums.length]>=-1){
                maxLength = Math.max(maxLength, i-arr[count+nums.length]);
            }
            else{
                arr[count+nums.length] = i;
            }
        }
        return maxLength;
    }
}