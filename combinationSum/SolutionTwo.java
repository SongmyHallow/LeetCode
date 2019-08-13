import java.util.*;
/**
 * Given a collection of candidate numbers (candidates) and a target 
 * number (target), find all unique combinations in candidates where 
 * the candidate numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
 */
public class SolutionTwo {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> cur, int[] candidates, int remain, int start){
        if(remain == 0){
            ans.add(new ArrayList<>(cur));
        }
        else if(remain < 0){
            return;
        }
        else{
            for(int i=start; i<candidates.length; i++){
                if(i>start && candidates[i]==candidates[i-1])
                    continue;
                cur.add(candidates[i]);
                backtrack(ans, cur, candidates, remain-candidates[i], i+1);
                cur.remove(cur.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        SolutionTwo sol = new SolutionTwo();
        System.out.println(sol.combinationSum2(candidates, target));
    }
}