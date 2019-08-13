import java.util.*;
/**
 * Given a collection of numbers that might contain duplicates, 
 * return all possible unique permutations.
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(ans, new ArrayList<>(), nums, used);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> cur, int[] nums, boolean[] used){
        if(cur.size() == nums.length){
            ans.add(new ArrayList<>(cur));
        }
        else{
            for(int i=0; i<nums.length; i++){
                if(used[i] || (i>0 && nums[i]==nums[i-1] && used[i-1])){
                    continue;
                }
                
                cur.add(nums[i]);
                used[i] = true;
                backtrack(ans, cur, nums, used);
                cur.remove(cur.size()-1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        Solution sol = new Solution();
        System.out.println(sol.permuteUnique(nums));
    }
}