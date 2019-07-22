import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a string and a string dictionary, find the longest string in 
 * the dictionary that can be formed by deleting some characters of the 
 * given string. If there are more than one possible results, 
 * return the longest word with the smallest lexicographical order. 
 * If there is no possible result, return the empty string.
 */

public class Solution{
    public String findLongestWord(String s, List<String> d){
        Collections.sort(d,new Comparator<String>() {
            public int compare(String s1, String s2){
                return s2.length()!=s1.length() ? s2.length()-s1.length():s1.compareTo(s2);
            }
        });
        for(String str:d){
            if(isSubSequence(str, s))
                return str;
        }

        return "";
    }

    public boolean isSubSequence(String x, String y){
        int j=0; 
        for(int i=0; i<y.length()&&j<x.length();i++){
            if(x.charAt(j) == y.charAt(i))  
                j++;
        }
        return j==x.length();
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> d = Arrays.asList("ale","apple","monkey","plea");
        Solution sol = new Solution();
        System.out.println(sol.findLongestWord(s, d));
    }
}