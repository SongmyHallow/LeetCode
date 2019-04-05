package ArrayOrder;

import java.util.Arrays;

public class TestDriver {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MySolution sol = new MySolution();
        int[] Array = {19,23,325,24,45,28,54,29,92};
        sol.reOrderArray(Array);
        System.out.println(Arrays.toString(Array));
    }

}
