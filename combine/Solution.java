import java.util.*;
/**
 * Given two integers n and k, return all possible combinations of 
 * k numbers out of 1 ... n.
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(),1, n, k);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> cur, int start, int n, int k){
        if(cur.size() == k){
            ans.add(new ArrayList<>(cur));
        }
        else{
            for(int i=start; i<=n; i++){
                cur.add(i);
                backtrack(ans, cur, i+1, n, k);
                cur.remove(cur.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        int n = 4, k = 2;
        Solution sol = new Solution();
        System.out.println(sol.combine(n, k));
    }
}