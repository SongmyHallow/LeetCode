package InversePairs;

import java.util.Arrays;

public class solution{
  int counter = 0;
  public int InversePairs(int[] array){
    if(array.length<=1 || array==null)  return 0;
   
    int middle = array.length >> 1;
    int[] leftArr = Arrays.copyOfRange(array, 0, middle);
    int[] rightArr = Arrays.copyOfRange(array, middle, array.length);

  }

  private int[] merge(int[] arr1, int[] arr2){
    int i=0, j=0, k=0;
    int[] result = new int[arr1.length + arr2.length];
    while(i < arr1.length && j < arr2.length){
      if(arr1[i] <= arr2[j]){
        result[k++] = arr1[i++];
      }else{
        result[k++] = arr2[j++];
      }
    }

    return result;
  }
}
