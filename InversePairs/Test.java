package InversePairs;

public class Test{
    public static void main(String[] args) {
        int[] test = {1,2,3,4,5,6,7,0};
        solution sol = new solution();
        int count = sol.InversePairs(test);
        System.out.println(count);
    }
}