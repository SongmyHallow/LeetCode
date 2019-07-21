public class Solution_optimizedWindow{
    public boolean checkInclusion(String s1, String s2){
        if(s1.length() > s2.length())   return false;

        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        // store the number of characters, which have the same
        // frequency of occurence in s1 and the current window in s2
        int count = 0;
        for(int i=0; i<26; i++){
            if(s1map[i]==s2map[i])
                count++;
        }

        for(int i=0; i<s2.length()-s1.length();i++){
            int r = s2.charAt(i+s1.length())-'a';   // right
            int l = s2.charAt(i)-'a';               // left

            if(count==26)   return true;

            s2map[r]++;
            // to see if character out of range leads to mismatch
            if(s2map[r]==s1map[r])  count++;
            else if(s2map[r]==s1map[r]+1)   count--;
            
            s2map[l]--;
            
            if(s2map[l]==s1map[l])  count++;
            else if(s2map[l]==s1map[l]+1)   count--;
        }
        return count==26;
    }
}