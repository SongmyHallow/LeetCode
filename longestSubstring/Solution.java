import java.util.Arrays;

/**
 * For each h, apply two pointer technique to find the longest substring 
 * with at least K repeating characters and the number of unique characters 
 * in substring is h.
 */
public class Solution{
    public int longestSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        // h:character; i:left of window; j:right of window
        int h,i,j;
        // unique:only one occurence; noLessThanK:multuple occurence
        int idx, max=0, unique, noLessThanK;

        for(h=1; h<=26; h++){
            // Initialization of the number of each character
            Arrays.fill(count, 0);
            i=0; j=0;
            unique = 0;
            noLessThanK = 0;
            // find all sub-strings which have "h=1,2..." unique character(s) and 
            // each character in the substring repeats at least "k" times
            // For example, when h=3, K=5, we are going to find the longest 
            // window contains exactly 3 unique characters and each repeating 5 times.

            while(j < chars.length){
                // expand (j++) as long as the num of unique characters 
                // between 'i' to 'j' are h or less (unique <= h)
                if(unique <= h){
                    idx = chars[j] - 'a';
                    if(count[idx] == 0) unique++;
                    count[idx]++;
                    if(count[idx] == k) noLessThanK++;
                    j++;
                }
                else{
                    idx = chars[i] - 'a';
                    if(count[idx] == k) noLessThanK--;
                    count[idx]--;
                    if(count[idx] == 0) unique--;
                    i++;
                }
                if(unique == h && unique == noLessThanK)
                    max = Math.max(j-i, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "ababbc";
        int k = 2;
        Solution sol = new Solution();
        System.out.println(sol.longestSubstring(s, k));
    }
}