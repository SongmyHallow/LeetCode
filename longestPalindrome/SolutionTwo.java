import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length 
 * of the longest palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 */
public class SolutionTwo {
    public int longestPalindrome(String s) {
        Map<Character,Integer> count = new HashMap<>();
        
        for(char c:s.toCharArray())
            count.put(c, count.getOrDefault(c, 0)+1);
        
        int ans = 0;
        for(char c:count.keySet()){
            // 只添加偶数个
            ans += count.get(c) / 2 * 2;
            // 已经有偶数对元素，而且当前元素只有一个
            if(ans % 2 == 0 && count.get(c) % 2 == 1)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        SolutionTwo sol = new SolutionTwo();
        System.out.println(sol.longestPalindrome(s));
    }
} 