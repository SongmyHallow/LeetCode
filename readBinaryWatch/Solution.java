import java.util.ArrayList;
import java.util.*;
/**
 * A binary watch has 4 LEDs on the top which represent
 * the hours (0-11), and the 6 LEDs on the bottom represent
 * the minutes (0-59).
 * Each LED represents a zero or one, with the least 
 * significant bit on the right.
 * 
 * Given a non-negative integer n which represents the number of LEDs 
 * that are currently on, return all possible times the watch could 
 * represent.
 */
public class Solution {
    
    public List<String> readBinaryWatch(int num) {
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0; i<12; i++){
            for(int j=0; j<60; j++){
                if(Integer.bitCount(i)+Integer.bitCount(j)==num)
                    ans.add(String.format("%d:%02d", i,j));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int num = 1;
        Solution sol = new Solution();
        System.out.println(sol.readBinaryWatch(num));
    }
}