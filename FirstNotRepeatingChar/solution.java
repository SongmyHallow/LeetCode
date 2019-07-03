package FirstNotRepeatingChar;

import java.util.HashMap;

public class solution{
    public int FirstNotRepeatingChar(String str){
        int len = str.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<len; i++){
            if(map.containsKey(str.charAt(i))){
                int time = map.get(str.charAt(i));
                map.put(str.charAt(i), ++time);
            }
            else{
                map.put(str.charAt(i), 1);
            }
        }
        int pos = -1;
        for(int i=0; i<len; i++){
            char c = str.charAt(i);
            if(map.get(c)==1){
                return i;
            }
        }
        return pos;
    }
}