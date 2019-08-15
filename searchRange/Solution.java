import java.util.Arrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting 
 * and ending position of a given target value
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        int index = BinarySearch(nums, target, 0, nums.length-1);
        if(index == -1)
            return ans;
        int left = index, right = index;
        while(left>=0&&nums[left] == target)
            left--;
        while(right<=nums.length-1&&nums[right] == target)
            right++;
        return new int[]{left+1,right-1};
    }

    public int BinarySearch(int[] nums, int target, int low, int high){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target){
                return BinarySearch(nums, target, mid+1, high);
            }
            else{
                return BinarySearch(nums, target, low, mid-1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 6;
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.searchRange(nums, target)));
    }
}