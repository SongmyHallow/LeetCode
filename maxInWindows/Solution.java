import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution{
  public ArrayList<Integer> maxInWindows(int[] num, int size){
    
    ArrayList<Integer> sol = new ArrayList<>();
    if( size<1 || size>num.length){
      return sol;
    }
    
    int index=0;
    // indices are stored in double ended queue
    ArrayDeque<Integer> qmax = new ArrayDeque<>();
    for(int i=0; i<num.length; i++){
      // compare from the left, kick out if values < incoming value
      while(!qmax.isEmpty() && num[qmax.peekLast()]<=num[i]){
        qmax.pollLast();
      }
      qmax.add(i);
      // tell if out of window
      if(qmax.peekFirst() == i-size){
        qmax.pollFirst();
      }
      // adjust the window, element on the most left is the minimum
      if(i >= size - 1){
        index++;
        sol.add(num[qmax.peekFirst()]);
      }
    }
    return sol;
  }
  
}
