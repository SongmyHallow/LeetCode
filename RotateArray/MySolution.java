package RotateArray;
public class MySolution {
	public int minNumberInRotateArray(int [] array) {
		if(array.length==0) {
			return 0;
		}
		if(array.length==1) {
			return array[0];
		}
		for(int i=0; i<array.length; i++) {
			if(array[i+1]<array[i]) {
				return array[i+1];
			}
			
		}
		return array[array.length-1];
		
	}
}
