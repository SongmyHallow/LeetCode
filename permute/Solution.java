import java.util.*;
/**
 * Given a collection of distinct integers, return all 
 * possible permutations.
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(ans, new ArrayList<>(), nums, new boolean[nums.length]);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> cur, int[] nums, boolean[] used){
        if(cur.size() == nums.length)
            ans.add(new ArrayList<>(cur));
        else{
            for(int i=0; i<nums.length; i++){
                if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1])
                    continue;
                used[i] = true;
                cur.add(nums[i]);
                backtrack(ans, cur, nums, used);
                used[i] = false;
                cur.remove(cur.size()-1);
            }
        }
        
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution sol = new Solution();
        System.out.println(sol.permute(nums));
    }
}