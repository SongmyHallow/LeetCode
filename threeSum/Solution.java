import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution{
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> sol = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i+2<nums.length; i++){
            // fix the first element of the triplet which should be different
            if(i==0 || (i>0 && nums[i] != nums[i-1])){
                // except the first element
                int lo = i+1, hi = nums.length-1, sum = 0-nums[i];
                while(lo < hi){
                    if(nums[lo] + nums[hi] == sum){
                        sol.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                        // get rid of the duplicate answer
                        while(lo < hi && nums[lo] == nums[lo+1])    lo++;
                        while(lo < hi && nums[hi] == nums[hi-1])    hi--;
                        lo++;hi--;
                    }
                    else if(nums[lo] + nums[hi] < sum)  lo++;
                    else                                hi--;
                }
            }
        }
        return sol;
    }

    public static void main(String[] args) {
        int[] test = {-1, 0, 1, 2, -1, -4};
        Solution sol = new Solution();
        System.out.println(sol.threeSum(test).toString());
        
    }
}