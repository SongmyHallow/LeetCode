import java.util.Arrays;

/**
 * Given a string s, you are allowed to convert it to a palindrome by adding characters 
 * in front of it. Find and return the shortest palindrome you can find by performing 
 * this transformation.
 */
public class Solution {
    public String shortestPalindrome(String s) {
        String temp = s+"#"+new StringBuilder(s).reverse().toString();
        int[] table = getTable(temp);
        System.out.println(Arrays.toString(table));
        return new StringBuilder(s.substring(table[table.length-1])).reverse().toString()+s;
    }

    public int[] getTable(String s){
        // get lookup table
        int[] table = new int[s.length()];
        // pointer that points to matches char in prefix part
        int index = 0;
        // skip index 0
        for(int i=1; i<s.length(); i++){
            if(s.charAt(index) == s.charAt(i)){
                // we can extend match in prefix and postfix
                table[i] = table[i-1] + 1;
                index++;
            }
            else{
                // match failed, we try to match a shorter substring

                // by assigning index to table[i-1], we will shorten the match string
                // length, and jump to the prefix part that we used to match postfix ended
                // at i-1
                index = table[i-1];

                while(index>0 && s.charAt(index)!=s.charAt(i)){
                    // we will try to shorten the match string length until
                    // we revert to the beginning of match
                    index = table[index-1];
                }

                // when we are here may either found a match char or we reach the 
                // boundary and still no luck, so we need check char match
                if(s.charAt(index) == s.charAt(i)){
                    // if match, then extend one char
                    index++;
                }

                table[i] = index;
            }
        }

        return table;
    }

    public String SolutionRecursive(String s){
        int j = 0;
        for(int i=s.length()-1; i>=0; i--)
            if(s.charAt(i)==s.charAt(j))
                j++;
        if(j == s.length())
            return s;
        // remove the first j indices
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString()+SolutionRecursive(s.substring(0,j)) + suffix;
    }

    public String KMP(String s){
        String r = new StringBuilder(s).reverse().toString();
        String t = s+"#"+r;

        int[] next = new int[t.length()];
        for(int i=1; i<t.length(); ++i){
            int j = next[i-1];
            while(j>0 && t.charAt(i)!=t.charAt(j))
                j = next[j-1];
            j += (t.charAt(i)==t.charAt(j)) ? 1:0;
            next[i] = j;
        }
        return r.substring(0,s.length()-next[t.length()-1])+s;
    }

    public static void main(String[] args) {
        String s = "abad";
        Solution sol = new Solution();
        System.out.println(sol.KMP(s));
    }
}