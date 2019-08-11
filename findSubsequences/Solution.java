import java.util.*;
/**
 * Given an integer array, your task is to find all the different possible 
 * increasing subsequences of the given array, and the length of an 
 * increasing subsequence should be at least 2.
 */
public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans = new HashSet<List<Integer>>();
        List<Integer> holder = new ArrayList<>();
        backtrack(ans, holder, nums, 0);
        List result = new ArrayList<>(ans);
        return result;

    }

    public void backtrack(Set<List<Integer>> ans,List<Integer> cur, int[] nums, int start){
        if(cur.size()>=2)
            ans.add(new ArrayList<>(cur));
        for(int i=start; i<nums.length; i++){
            if((cur.size()==0 || cur.get(cur.size()-1)<= nums[i])){
                cur.add(nums[i]);
                backtrack(ans, cur, nums, i+1);
                cur.remove(cur.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,6,7,7};
        Solution sol = new Solution();
        System.out.println(sol.findSubsequences(nums));
    }
}