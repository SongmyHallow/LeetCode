import java.util.*;/**
 * Given a set of distinct integers, nums, return 
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length == 0)
            return ans;

        backtrack(ans, nums, new ArrayList<>(), 0);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, int[] nums, List<Integer> cur, int start){
        ans.add(new ArrayList<>(cur));
        for(int i=start; i<nums.length; i++){
            cur.add(nums[i]);
            backtrack(ans, nums, cur, i+1);
            // remove the last element
            cur.remove(cur.size()-1);
        }
    }

    // contains ducplicates
    public void backtrackWithDuplicates(List<List<Integer>> ans, int[] nums, List<Integer> cur, int start){
        ans.add(new ArrayList<>(cur));
        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i]==nums[i-1])
                continue;
            cur.add(nums[i]);
            backtrackWithDuplicates(ans, nums, cur, i+1);
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution sol = new Solution();
        System.out.println(sol.subsets(nums));
    }
}