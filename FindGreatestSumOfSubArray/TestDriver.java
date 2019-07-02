package FindGreatestSumOfSubArray;

public class TestDriver {
    public static void main(String[] args) {
        int[] test = {6,-3,-2,7,-15,1,2,2};
        solution sol = new solution();
        int maxSum = sol.FindGreatestSumOfSubArray(test);
        System.out.println(maxSum);
    }
}