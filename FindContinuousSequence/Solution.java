import java.util.ArrayList;
public class Solution{
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum){
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        int pointLow = 1, pointHigh = 2;
        while(pointHigh > pointLow){
            // 等差数列求和公式
            int cur = (pointHigh+pointLow)*(pointHigh-pointLow+1)/2;
            // 相等，则将窗口范围内所有数添加进结果
            if(cur == sum){
                ArrayList<Integer> temp = new ArrayList<>();
                for(int i=pointLow; i<=pointHigh; i++){
                    temp.add(i);
                }
                sol.add(temp);
                pointLow++;
            }
            // 窗口内的值小于目标，右边窗口向右滑动
            else if(cur < sum){
                pointHigh++;
            }
            // 窗口内的值大于目标，左边窗口向右滑动
            else{
                pointLow++;
            }
        }
        return sol;
    }
}