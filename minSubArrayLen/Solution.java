/**
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a contiguous subarray of which 
 * the sum ≥ s. If there isn't one, return 0 instead.
 */

public class Solution{
    public int minSubArrayLen(int s, int[] nums){
        int sum = 0;
        int left = 0, right = 0;
        int minLength = nums.length+1;
        while(right < nums.length){
            sum+=nums[right];
            if(sum>=s && right-left+1<minLength){
                minLength = right-left+1;
            }
            while(left<right && sum>=s){
                sum-=nums[left];
                left++;
                if(sum>=s&& right-left+1<minLength){
                    minLength = right-left+1;
                }
                
            }

            right++;
        }
        if(minLength==nums.length+1)   return 0;
        else                return minLength;
    }

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2,3,1,2,4,3};
        Solution sol = new Solution();
        System.out.println(sol.minSubArrayLen(s, nums));
    }

}