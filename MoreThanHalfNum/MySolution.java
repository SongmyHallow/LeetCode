package MoreThanHalfNum;

public class MySolution {
	public int MoreThanHalfNum_Solution(int [] array) {
		int[] array2 = new int[array.length];
        for(int i=0; i<array.length; i++){
            int counter = 0;
            if(array2[i] == 1){
                continue;
            }
            for(int j=i; j<array.length; j++){
                
                if(array[i] == array[j]){
                    counter++;
                    array2[j] = 1;
                }
                if(counter > array.length/2){
                    return array[i];
                }
            }
        }
        return 0;
	}
}
