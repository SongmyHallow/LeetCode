import java.util.Arrays;
import java.util.Stack;

public class Solution{
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]){
        if(array.length == 0){
            num1[0] = 0;
            num2[0] = 0;
            return;
        }
        Arrays.sort(array);
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<array.length; i++){
            if(stack.isEmpty()){
                stack.push(array[i]);
            }
            else if(stack.peek()==array[i]){
                stack.pop();
            }else{
                stack.push(array[i]);
            }
        }
        num1[0] = stack.pop();
        num2[0] = stack.pop();

    }
}