import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution{
    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> sol = new ArrayList<>();
        if(nums.length==0)  return sol;

        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        
        find(nums, 0, 0, target, nums[nums.length-1], temp, sol);
        return sol;
    }

    private void find(int[] nums, int start, int sum, int target, int maxVal, List<Integer> temp, List<List<Integer>> sol){
        if(temp.size() == 4){
            if(sum == target){
                sol.add(new ArrayList<Integer>(temp));
            }
        }

        if(start == nums.length)    return;
        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i] == nums[i-1]) continue;
            // nums[i] is too small
            if(sum + nums[i] + maxVal*(4-temp.size()-1) < target)   continue;
            // nums[i] is too big
            if(sum + nums[i] * (4-temp.size()) > target)    continue;

            temp.add(nums[i]);
            find(nums,i+1,(sum+nums[i]),target,maxVal, temp, sol);
            temp.remove(temp.size() - 1);
        }
    } 
        
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        int target = -1;
        Solution sol = new Solution();
        System.out.println(sol.fourSum(nums,target));
    }
}