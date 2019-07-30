/**
 * Given n non-negative integers representing an elevation map where 
 * the width of each bar is 1, compute how much water it is able to 
 * trap after raining.
 */
class Solution {
    public int trap(int[] height) {
        int lp = 0, rp = height.length-1;
        int ans = 0;
        int leftMax = 0, rightMax = 0;
        while(lp<rp){
            if(height[lp]>leftMax)  leftMax = height[lp];
            if(height[rp]>rightMax) rightMax = height[rp];
            // a taller bar exists on left pointer's right side
            if(leftMax<rightMax){
                ans+=Math.max(0, leftMax-height[lp]);
                lp++;
            }
            // a taller bar exists on right pointer's left side
            else{
                ans+=Math.max(0, rightMax-height[rp]);
                rp--;
            }
        }
        return ans;
        
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        Solution sol = new Solution();
        System.out.println(sol.trap(height));
    }
}