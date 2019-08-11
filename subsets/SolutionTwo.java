import java.util.ArrayList;
import java.util.*;
/**
 * Given a collection of integers that might contain 
 * duplicates, nums, return all possible subsets 
 * (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 */
public class SolutionTwo{
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(ans, nums, new ArrayList<>(), 0);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, int[] nums, List<Integer> cur, int start){
        ans.add(new ArrayList<>(cur));
        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i]==nums[i-1])
                continue;
            cur.add(nums[i]);
            backtrack(ans, nums, cur, i+1);
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        SolutionTwo sol = new SolutionTwo();
        System.out.println(sol.subsetsWithDup(nums));
    }
}