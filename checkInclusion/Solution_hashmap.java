import java.util.HashMap;

public class Solution_hashmap{
    public boolean checkInclusion(String s1, String s2){
        if(s1.length() > s2.length())   return false;

        // The frequency of every character appearing in s1
        HashMap<Character,Integer> s1map = new HashMap<>();
        for(int i=0; i<s1.length(); i++){
            s1map.put(s1.charAt(i), s1map.getOrDefault(s1.charAt(i), 0)+1);
        }

        for(int i=0; i<=s2.length()-s1.length(); i++){
            HashMap<Character,Integer> s2map = new HashMap<>();
            for(int j=0; j<s1.length(); j++){
                s2map.put(s2.charAt(i+j), s2map.getOrDefault(s2.charAt(i+j), 0)+1);
            }
            if(match(s1map, s2map)) return true;
        }
        return false;
    }
    /**
     * If the two hashmaps obtained are identical for any such window, 
     * we can conclude that s1's permutation is a substring of s2, otherwise not.
     */
    public boolean match(HashMap<Character,Integer> s1map, HashMap<Character,Integer> s2map){
        for(char key: s1map.keySet()){
            if(s1map.get(key) - s2map.getOrDefault(key, -1) != 0)   return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        Solution_hashmap sol = new Solution_hashmap();
        System.out.println(sol.checkInclusion(s1, s2));
    }
}