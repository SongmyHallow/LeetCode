package movingCount;

public class Solution {
    
    public int movingCount(int threshold, int rows, int cols){
        boolean[][] flag = new boolean[rows][cols];
        int count = moveHelper(threshold, rows, cols, 0, 0, flag);
        return count;
    }

    private int moveHelper(int threshold, int rows, int cols, int row, int col, boolean[][] flag){
        if(row<0|| row>=rows||col<0||col>=cols||flag[row][col]||bitsum(row)+bitsum(col)>threshold){
            return 0;
        }
        flag[row][col] = true;
        System.out.println("row:"+row+" col:"+col);
        return moveHelper(threshold, rows, cols, row+1, col, flag)+moveHelper(threshold, rows, cols, row-1, col, flag)+moveHelper(threshold, rows, cols, row, col+1, flag)+moveHelper(threshold, rows, cols, row, col-1, flag)+1;
    }
    
    private int bitsum(int t){
        int count = 0;
        while(t!=0){
            count+= t%10;
            t/=10;
        }
        return count;
    }

    public static void main(String[] args) {
        int threshold = 18, rows=40, cols=40;
        Solution sol = new Solution();
        int result = sol.movingCount(threshold,rows,cols);
        System.out.println(result);
    }
}