import java.util.ArrayList;
import java.util.Arrays;

public class Solution{
  ArrayList<Integer> stream = new ArrayList<>();
  
  public void Insert(Integer num){
    stream.add(num);
  }

  public Double GetMedian(){
    int length = stream.size();
    if(length==0){
      return 0.0;
    }
    Integer[] arrayStream = (Integer[])stream.toArray(new Integer[length]);
    Arrays.sort(arrayStream);
    if(length%2==0){
      return (arrayStream[length/2-1]+arrayStream[length/2])/2.0;
    }
    else{
      return (double)arrayStream[length/2];
    }
  }
}