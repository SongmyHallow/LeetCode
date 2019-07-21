public class Solution{
    public double findMaxAverage(int[] nums, int k){
        // create a cumulative sum array
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            sum[i] = sum[i-1] + nums[i];
        }
        double res = sum[k-1] * 1.0 / k;
        for(int i = k; i<nums.length; i++){
            res = Math.max(res, (sum[i] - sum[i-k])*1.0/k);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {7,4,5,8,8,3,9,8,7,6};
        int k = 7;
        Solution sol = new Solution();
        System.out.println(sol.findMaxAverage(nums, k));
    }
}
