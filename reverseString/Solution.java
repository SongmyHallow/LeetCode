import java.util.Arrays;

/**
 * Write a function that reverses a string. The input string is 
 * given as an array of characters char[].
 * 
 * Do not allocate extra space for another array, you must 
 * do this by modifying the input array in-place with O(1) extra memory.
 * 
 * You may assume all the characters consist of printable ascii characters.
 */
class Solution {
    public void reverseString(char[] s) {
        int p1 = 0, p2 = s.length-1; 
        char temp;
        while(p1<=p2){
            temp = s[p1];
            s[p1++] = s[p2];
            s[p2--] = temp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        Solution sol = new Solution();
        sol.reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}