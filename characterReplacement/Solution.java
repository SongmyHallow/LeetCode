/**
 * Given a string s that consists of only uppercase English letters, 
 * you can perform at most k operations on that string.
 * 
 * In one operation, you can choose any character of the string and 
 * change it to any other uppercase English character.
 * 
 * Find the length of the longest sub-string containing all repeating 
 * letters you can get after performing the above operations.
 */
public class Solution{
    // Since we are only interested in the longest valid substring, 
    // our sliding windows need not shrink, even if a window may cover an invalid substring.
    public int characterReplacement(String s, int k){
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for(int end = 0; end < s.length(); end++){
            // maxCount = largest count of a single, unique character in the current window
            maxCount = Math.max(maxCount, ++count[s.charAt(end)-'A']);
            // constraint condition to shrink window
            while(end-start+1-maxCount>k){
                // end-start+1 = size of the current window
                count[s.charAt(start)-'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end-start+1);
        }   
        return maxLength;
    }
}