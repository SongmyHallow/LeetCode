package Search2dArray;

public class TestDriver {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RefSolution Exist = new RefSolution();
        
        int[][] testArray = {{1,2,3,4,5,6},{3,4,5,6,7,8}};
        int targetNum = 7;
        
        boolean sol = Exist.Find(targetNum, testArray);
        System.out.println("The result is:"+sol);
    }
}
