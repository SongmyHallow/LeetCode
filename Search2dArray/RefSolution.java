package Search2dArray;
public class RefSolution {
    public boolean Find(int target, int[][] array) {
        int rowCount = array.length;;
        int colCount = array[0].length;
        
        //i: row's number; j: column's number
        for(int i=rowCount-1,j=0;i>=0 && j<colCount;) {
            if(target == array[i][j])   return true;
            if(target < array[i][j]) {
                i--;
                continue;
            }
            if(target > array[i][j]) {
                j++;
                continue;
            }
        }
        return false;
    }
}
