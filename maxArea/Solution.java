/**
 * Given n non-negative integers a1, a2, ..., an , where each represents 
 * a point at coordinate (i, ai). n vertical lines are drawn such that 
 * the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
 * which together with x-axis forms a container, such that the container 
 * contains the most water.
 */
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int lp = 0, rp = height.length-1;
        while(lp<rp){
            maxArea = Math.max(maxArea, Math.min(height[lp],height[rp])*(rp-lp));
            if(height[lp]<height[rp])   lp++;
            else                        rp--;   
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,2,100,1,1,1,1,1,2};
        Solution sol = new Solution();
        System.out.println(sol.maxArea(height));
    }
}