import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution{
    public int findPairs(int[] nums, int k){
        int count = 0;
        if(k<0) return count;
        Map<Integer, ArrayList> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                if(k==0 && map.get(nums[i]).size()==1)    count++;
                map.get(nums[i]).add(i);
            }
            else{
                int x1 = nums[i] + k;
                int x2 = nums[i] - k;
                if(map.containsKey(x1)){
                    count ++ ;
                }
                if(map.containsKey(x2)){
                    count ++ ;
                }
                ArrayList<Integer> index = new ArrayList<>();
                index.add(i);
                map.put(nums[i], index);
            }
        }
        return count;
    }
}