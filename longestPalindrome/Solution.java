/**
 * Given a string s, find the longest palindromic substring in s. 
 * You may assume that the maximum length of s is 1000.
 */
public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int palindromeStartsAt = 0, maxLen = 0;

        boolean[][] dp = new boolean[n][n];
        // dp[i][j] indicates whether substring s starting at index i and ending at j is palindrome

        for(int i=n-1; i>=0; i--){// keep increasing the possible palindrome string
            // 先i后j
            for(int j=i; j<n; j++){// find the max palindrome within this window [i,j]
                // check if substring between (i,j) is palindrome
                dp[i][j] = (s.charAt(i) == s.charAt(j)) // chars at i and j should match
                            &&
                            // if window is less than or equal to 3, just end chars should match
                            // if window > 3, substring (i+1,j-1) should be palindrome
                            (j-i<3 || dp[i+1][j-1]);

                // update max palindrome string
                if(dp[i][j] && (j-i+1 > maxLen)){
                    palindromeStartsAt = i;
                    maxLen = j-i+1;
                }
            }
        }

        return s.substring(palindromeStartsAt, palindromeStartsAt+maxLen);
    }

    public static void main(String[] args) {
        String s = "abcda";
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome(s));
    }
}