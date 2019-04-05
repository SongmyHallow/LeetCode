package ArrayOrder;

import java.util.Arrays;

public class MySolution {
    public void reOrderArray(int[] array) {
        if(array.length == 0) {
            return;
        }
        else {
            String oddNum = "";
            String evenNum = "";
            
            for(int i=0; i<array.length; i++) {
                if(array[i]%2 != 0) oddNum = oddNum + array[i] + " ";
                else                evenNum = evenNum + array[i] + " " ;
            }
            System.out.println(oddNum);
            System.out.println(evenNum);
            
            String[] solNum = (oddNum + evenNum).split(" ");
            
            System.out.println(Arrays.toString(solNum));
            
            for(int j=0; j<solNum.length; j++) {
                array[j] = Integer.parseInt(solNum[j]);
            }
        }
    }
}
