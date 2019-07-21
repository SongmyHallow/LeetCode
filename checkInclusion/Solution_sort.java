import java.util.Arrays;

/**
 * one string will be a permutation of another string 
 * only if both of them contain the same characters
 * the same number of times
 */
public class Solution_sort{
    public boolean checkInclusion(String s1, String s2){
        s1 = sort(s1);
        for(int i=0; i<=s2.length()-s1.length(); i++){
            if(s1.equals(s2.substring(i,i+s1.length()))){
                return true;
            }
        }
        return false;
    }

    public String sort(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}