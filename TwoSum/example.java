package TwoSum;

import java.util.Arrays;

public class example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayEx = {3,3};
		solution result = new solution();
		result.twoSum(arrayEx, 6);
		
		solution_hashmap result2 = new solution_hashmap();
		int[] sol = result2.twoSum(arrayEx, 6);
		System.out.println(Arrays.toString(sol));
	}
	
}
