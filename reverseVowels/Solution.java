/**
 * Write a function that takes a string as input and reverse 
 * only the vowels of a string.
 */
public class Solution {
    public String reverseVowels(String s) {
        if(s==null || s.length()==0)
            return s;
        String vowels = "aeiouAEIOU";

        char[] str = s.toCharArray();
        int front = 0, end = str.length-1;
        while(front < end){
            while(front<end && !vowels.contains(str[front]+"")){
                front++;
            }
            while(front<end && !vowels.contains(str[end]+"")){
                end--;
            }
            
            char temp = str[front];
            str[front++] = str[end];
            str[end--] = temp;   
        }
        return new String(str);
    }
    public static void main(String[] args) {
        String s = "leetcode";
        Solution sol = new Solution();
        System.out.println(sol.reverseVowels(s));
    }
}