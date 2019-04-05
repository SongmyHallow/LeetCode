package TwoSum;

public class solution {
	public int[] twoSum(int[] nums, int target) {
		int[] sol = new int[2];
		for(int i=0; i<nums.length;i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i]+nums[j] == target) {
					System.out.println("First index:"+i);
					System.out.println("Second index:"+j);
					sol[0] = i;
					sol[1] = j;
				}
			}
		}
		return sol;
	}
}
