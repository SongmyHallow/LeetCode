/**
 * Given a string, your task is to count how many palindromic substrings 
 * in this string.
 * The substrings with different start indexes or end indexes are counted 
 * as different substrings even they consist of same characters.
 */
public class Solution {
    /**
     * 
     * Let N be the length of the string. The middle of the palindrome could be in one of 
     * 2N - 1 positions: either at letter or between two letters.
     * 
     * For each possible palindrome center, let's expand our candidate palindrome on the 
     * interval [left, right] as long as we can. The condition for expanding is left >= 0 
     * and right < N and S[left] == S[right]. That means we want to count a new palindrome
     *  S[left], S[left+1], ..., S[right].
     */
    private int ans = 0;

    public int countSubstrings(String s) {
        if(s==null)
            return 0;
        int len = s.length();
        
        if(len < 2)
            return 1;

        for(int i=0; i<len; i++){
            //输出的子串长度都是奇数，从中间某个位向两边比较
            extendPalindrome(s, i, i);
            //输出的子串长度都是偶数，从中间两个相邻的位分别向两边比较
            extendPalindrome(s, i, i+1);
        }
        return ans;
    }

    public void extendPalindrome(String s, int j,int k){
        while(j>=0 && k<s.length() && s.charAt(j)==s.charAt(k)){
            j--;
            k++;
            ans++;
        }
    }

    public static void main(String[] args) {
        String s = "aaa";
        Solution sol = new Solution();
        System.out.println(sol.countSubstrings(s));
    }
}