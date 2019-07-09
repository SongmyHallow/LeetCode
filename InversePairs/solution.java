package InversePairs;

import java.util.Arrays;

public class solution{
    public int InversePairs(int[] array){
        if(array == null || array.length == 0)  return 0;
        // 复制了一次原始数组
        int[] copy = new int[array.length];
        for(int i=0; i<array.length; i++){
            copy[i] = array[i];
        }
        int count = merge(array,copy,0,array.length-1);
        return count;

    }
    private int merge(int[] arr, int[] copy, int low, int high){
        if(low==high)   return 0;
        // 找到中点
        int mid = (low+high) >> 1;
        int leftCount = merge(arr, copy, low, mid)%1000000007;
        int rightCount = merge(arr, copy, mid+1, high)%1000000007;

        int count = 0;
        // 左右数组的右侧位点
        int i = mid, j = high;
        int locCopy = high;
        while(i>=low && j>mid){
            if(arr[i] > arr[j]){
                count += j - mid; // 右侧数组长度
                copy[locCopy--] = arr[i--];
                if(count >= 1000000007) count %= 1000000007; 
            }
            else{ // arr[i] <= arr[j]
                copy[locCopy--] = arr[j--];
            }
        }
        for(;i>=low;i--){
            copy[locCopy--] = arr[i];
        }
        for(;j>mid;j--){
            copy[locCopy--] = arr[j];
        }
        for(int s=low; s<=high; s++){
            arr[s] = copy[s];
        }
        return (leftCount+rightCount+count)%1000000007;
    }
}