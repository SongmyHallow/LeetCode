import java.util.ArrayList;
// 夹逼，既然是升序序列，左右夹第一组满足条件的就是乘积最大的
public class Solution{
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum){
        ArrayList<Integer> sol = new ArrayList<>();
        if(array == null || array.length < 2)   return sol;
        int lPoint = 0, rPoint = array.length-1;
        while(lPoint < rPoint){
            if(array[lPoint] + array[rPoint]==sum){
                sol.add(array[lPoint]);
                sol.add(array[rPoint]);
                return sol;
            }
            else if(array[rPoint]+array[lPoint] > sum){
                rPoint--;
            }
            else{
                lPoint++;
            }
        }
        return sol;
    }
}