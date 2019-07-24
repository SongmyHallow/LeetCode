import java.util.HashMap;
import java.util.Map;

public class Solution_HashMap{
    public int findMaxLength(int[] nums){
        int maxLength = 0, count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            count = count+(nums[i]==1 ? 1:-1);
            if(map.containsKey(count)){
                maxLength = Math.max(maxLength,i-map.get(count));
            }
            else{
                map.put(count, i);
            }
        }
        return maxLength;
    }
}