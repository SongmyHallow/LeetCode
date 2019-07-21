import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution{
   
    public double[] medianSlidingWindow(int[] nums, int k){
        // min for numbers smaller than current emdian
        // max for numbers bigger than and equal to current median
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(1000,Collections.reverseOrder());
        double[] sol = new double[nums.length-k+1];        
        for(int i=0; i<nums.length; i++){
            // make sure that the size of max array >= min
            if(max.size() <= min.size()){
                min.add(nums[i]);
                max.add(min.remove());
            }
            else{
                max.add(nums[i]);
                min.add(max.remove());
            }
            // the median number
            if(max.size() + min.size() == k){
                double median;
                if(max.size() == min.size())    median = (double)((long)max.peek()+(long)min.peek())/2.0;
                else                            median = max.peek();
                // add solution
                int start = i-k+1;
                sol[start] = median;
                // delete the oldest element
                if(!max.remove(nums[start])){
                    min.remove(nums[start]);
                }

            }
        }
        return sol;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.medianSlidingWindow(nums, k)));
    }
}