import java.util.Arrays;

public class Solution{
    public int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int result = nums[0]+nums[1]+nums[nums.length-1];
        for(int i=0;i<nums.length-2;i++){
            int start = i+1, end = nums.length-1;
            while(start<end){
                int sum = nums[i]+nums[start]+nums[end];
                if(sum > target)    end--;
                else                start++;

                if(Math.abs(sum-target) < Math.abs(result-target)){
                    result = sum;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test = {1,1,-1,-1, 3};
        int target = -1;
        Solution sol = new Solution();
        System.out.println(sol.threeSumClosest(test, target)); 
    }
}
