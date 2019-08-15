/**
 * Given a sorted array and a target value, return the index if 
 * the target is found. If not, return the index where it would 
 * be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target < nums[0])
            return 0;
        if(target > nums[nums.length-1])
            return nums.length;
        
        int index = BinarySeach(nums,target,0,nums.length-1);
        return index;
        }

    public int BinarySeach(int[] nums, int target, int low, int high) {
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] < target){
                if(nums[mid+1]>target)
                    return mid+1;
                else
                    return BinarySeach(nums, target, mid+1, high);
            }
            if(nums[mid] > target){
                if(nums[mid-1] < target)
                    return mid;
                else
                    return BinarySeach(nums, target, low, mid-1);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 4;
        Solution sol = new Solution();
        System.out.println(sol.searchInsert(nums, target));
    }
}