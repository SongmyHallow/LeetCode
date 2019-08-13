import java.util.*;
/**
 * Given a set of candidate numbers (candidates) (without duplicates) and 
 * a target number (target), find all unique combinations in candidates where 
 * the candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number 
 * of times
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(ans, new ArrayList<>(), 0, candidates, target);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> cur, int cursum, int[] candidates, int target){
        if(cursum == target){
            if(cur.size()>1 && cur.get(cur.size()-1) < cur.get(cur.size()-2))
                return;
            ans.add(new ArrayList<>(cur));
        }
        else if(cursum > target){
            return;
        }
        else{
            for(int i=0; i<candidates.length; i++){
                if(cur.size()>1 && cur.get(cur.size()-1) < cur.get(cur.size()-2))
                    continue;
                cur.add(candidates[i]);
                cursum += candidates[i];
                backtrack(ans, cur, cursum, candidates, target);
                cur.remove(cur.size()-1);
                cursum -= candidates[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        Solution sol = new Solution();
        System.out.println(sol.combinationSum(candidates, target));
    }
}