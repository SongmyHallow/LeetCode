import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution{
    public int[] maxSlidingWindow(int[] nums, int k){
        if(nums.length==0 || k<=0)  return new int[0];

        int[] sol = new int[nums.length-k+1];
        int index = 0;
        Deque<Integer> qmax = new ArrayDeque<>();
        for(int i=0; i<nums.length; i++){
            // remove numbers out of range k
            while(!qmax.isEmpty() && qmax.peek()<i-k+1){
                qmax.poll();
            }
            // remove smaller numbers in k range as they are useless
            while(!qmax.isEmpty() && nums[qmax.peekLast()] < nums[i]){
                qmax.pollLast();
            }
            // This method is equivalent to offerLast()
            qmax.offer(i);
            
            if(i >= k-1){
                sol[index++] = nums[qmax.peekFirst()];
            }
        }
        
        return sol;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.maxSlidingWindow(nums, k)));
    }

}