import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S 
 * which will contain all the characters in T in complexity O(n).
 * 
 * Note:
 * If there is no such window in S that covers all characters in T, 
 * return the empty string "".
 * If there is such window, you are guaranteed that there will 
 * always be only one unique minimum window in S.
 */

public class Solution{
    /**
     * sliding window problem
     * right pointer: expand the current window
     * left pointer: contract a given window
     * At any time only one of these pointers move and the 
     * other one remains fixed
     * 
     * 1. We start with two pointers, leftleft and rightright 
     *      initially pointing to the first element of the string SS.
     * 2. We use the rightright pointer to expand the window until 
     *      we get a desirable window i.e. a window that contains 
     *      all of the characters of TT.
     * 3. Once we have a window with all the characters, we can move 
     *      the left pointer ahead one by one. If the window is still 
     *      a desirable one we keep on updating the minimum window size.
     * 4. If the window is not desirable any more, we repeat step \; 
     *      2step2 onwards.
     */
    public String minWindow(String s, String t){
        if(s.length()==0 || t.length()==0)  return "";

        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }
        
        // number of unique characters in t
        int required = map.size();
        int left = 0, right = 0;
        // keep track of how many unique characters in t
        // are present in the current window in desired frequency
        int formed = 0;

        Map<Character,Integer> window = new HashMap<>();
        // (window length, left, right)
        int[] ans = {-1, 0, 0};
        while(right < s.length()){
            char c = s.charAt(right);
            int count = window.getOrDefault(c, 0);
            window.put(c, count+1);

            if(map.containsKey(c) && window.get(c).intValue()==map.get(c).intValue()){
                formed++;
            }

            while(left<=right && formed == required){
                c = s.charAt(left);
                // compare to minimize length of substring
                if(ans[0]==-1 || right-left+1<ans[0]){
                    ans[0] = right-left+1;
                    ans[1] = left;
                    ans[2] = right;
                }

                window.put(c, window.get(c)-1);
                if(map.containsKey(c)&&window.get(c).intValue()<map.get(c).intValue()){
                    formed--;
                }

                left++;
            }
            right++;
        }
        
        if(ans[0]==-1)  return "";
        else            return s.substring(ans[1], ans[2]+1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Solution sol = new Solution();
        System.out.println(sol.minWindow(s, t));
    }
}