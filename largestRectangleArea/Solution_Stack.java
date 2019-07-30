import java.util.Stack;

public class Solution_Stack{
    /**
     * Do push all heights including 0 height.
     * i - 1 - s.peek() uses the starting index where 
     * height[s.peek() + 1] >= height[tp], because the index 
     * on top of the stack right now is the first index left 
     * of tp with height smaller than tp's height.
     */
    public int largestRectangleArea(int[] heights){
        int len = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0;i<len; i++){
            int h = (i==len? 0:heights[i]);
            if(stack.isEmpty() || h>=heights[stack.peek()]){
                stack.push(i);
            }
            else{
                int tp = stack.pop();
                maxArea = Math.max(maxArea,heights[tp]*(stack.isEmpty()?i:i-1-stack.peek()));
                i--;
            }
        }
        return maxArea;
    }
}