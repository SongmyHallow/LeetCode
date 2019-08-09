import java.util.*;
/**
 * Given n pairs of parentheses, write a function to generate all combinations 
 * of well-formed parentheses.
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "",0,0, n);
        return ans;
    }

    // keep track of the number of opening and closing brackets we have placed so far
    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if(cur.length() == max*2){
            ans.add(cur);
            return;
        }

        if(open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if(close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }

    public static void main(String[] args) {
        int n = 3;
        Solution sol = new Solution();
        System.out.println(sol.generateParenthesis(n));
    }
}