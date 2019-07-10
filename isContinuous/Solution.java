import java.util.Arrays;

public class Solution{
    public boolean isContinuous(int[] numbers){
        if(numbers.length != 5) return false;
        
        Arrays.sort(numbers);
        int max = numbers[numbers.length-1];
        int min = 0;
        for(int i=0; i<numbers.length-1; i++){
            if(numbers[i]!=0){
                min = numbers[i];
                break;
            }
        }

        if(numbers.length==5 && max-min<5 && checkTwice(numbers)){
            return true;
        }
        return false;
    }

    private boolean checkTwice(int[] numbers){
        for(int i=0; i<numbers.length-1; i++){
            if(numbers[i] == numbers[i+1] && numbers[i]!=0){
                return false;
            }
        }
        return true;
    }
}