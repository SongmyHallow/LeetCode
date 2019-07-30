/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle 
 * containing only 1's and return its area.
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int ans = 0, row = matrix.length, column = matrix[0].length;
        int[] height = new int[column]; // height

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // an array to indicate '1'
                if (matrix[i][j] == '0') {
                    height[j] = 0;
                    continue;
                }
                height[j]++;
                
                for (int cur = j - 1, pre = height[j]; cur >= 0; cur--) {
                    if (height[cur] == 0) break;
                    pre = Math.min(pre, height[cur]);
                    ans = Math.max(ans, (j - cur + 1) * pre);
                }
                ans = Math.max(ans, height[j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        Solution sol = new Solution();
        System.out.println(sol.maximalRectangle(matrix));
    }
}