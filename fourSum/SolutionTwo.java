import java.util.HashMap;
import java.util.Map;

public class SolutionTwo{
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D){
        Map<Integer,Integer> map = new HashMap<>();
        // 先找出所有两个元素的加和值
        for(int i=0; i<C.length; i++){
            for(int j=0; j<D.length; j++){
                int sum = C[i]+D[j];
                // 如果已经存在对应的key，则直接改变对应的value
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }
        // 再看另两个数组有没有满足要求的组合
        int sol = 0;
        for(int i=0; i<A.length; i++){
            for(int j=0; j<B.length; j++){
                sol += map.getOrDefault(-1*(A[i]+B[j]), 0);
            }
        }
        return sol;
    }

    public static void main(String[] args) {
        int[] A = {1,2};
        int[] B = {-2,-1};
        int[] C = {-1,2};
        int[] D = {0,2};

        SolutionTwo sol = new SolutionTwo();
        System.out.println(sol.fourSumCount(A, B, C, D));
    }
}