import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/**
 * A problem with this method is that the maximum length of 
 * the string can be 32 only, since we make use of an integer 
 * and perform the shift operations on it to generate the binary numbers.
 */
public class Solution_binary{
    public String findLongestWord(String s, List<String> d){
        HashSet<String> set = new HashSet<>();
        List<String> l = new ArrayList<>();
        
        for(int i=0; i<(1<<s.length()); i++){
            String t = "";
            for(int j=0; j<s.length(); j++){
                if(((i>>j)&1)!=0)
                    t+=s.charAt(j);
            }
            l.add(t);
        }
        String max_str = "";
        for(String str:l){
            if(set.contains(str))
                if(str.length() > max_str.length() || (str.length()==max_str.length()&&str.compareTo(max_str)<0))
                    max_str = str;
        }
        return max_str;
    }
}