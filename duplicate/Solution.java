package duplicate;

import java.util.HashMap;

public class Solution{
    public boolean duplicate(int numbers[], int length, int[] duplication){
        if(numbers==null || length == 0)    return false;
        HashMap sol = new HashMap();
        for(int i=0; i<length; i++){
            if(!sol.containsKey(numbers[i])){
                sol.put(numbers[i], 1);
            }else{
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
}