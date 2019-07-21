/**
 * Given two strings s1 and s2, write a function to return 
 * true if s2 contains the permutation of s1. 
 * In other words, one of the first string's permutations is 
 * the substring of the second string.
 */
public class Solution_brute{
    int counter = 0;
    public boolean checkInclusion(String s1, String s2){
        if(s1.length() > s2.length())   return false;

        if(s1.length()==1){
            if(s2.indexOf(s1)>=0)    return true;
            else                    return false;
        }
        else{
            char[] chars= s1.toCharArray();
            permutation(chars, 0, s1.length()-1, s2);
            if(counter>0)   return true;
            else            return false;
        }

    }

    public void permutation(char[] chars, int from, int to, String str){
        if(to < 1) return;

        if(from == to){
            String temp = new String(chars);
            if(str.indexOf(temp) >= 0)    counter++;
        }
        else{
            for(int i=from; i<=to; i++){
                swap(chars, i, from);
                permutation(chars, from+1, to, str);
                swap(chars, from, i);
            }
        }
    }

    public void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        Solution_brute sol = new Solution_brute();
        System.out.println(sol.checkInclusion(s1, s2));
    }
}