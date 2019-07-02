package FindGreatestSumOfSubArray;

public class solution {
    public int FindGreatestSumOfSubArray(int[] array){
        if(array.length<1 && array==null)   return 0;
        int sol = 0;
        int max = 0;
        for(int i=0; i<array.length; i++){
            if(sol<=0)  sol=0;
            sol += array[i];
            max = Math.max(sol, max);
        }
        return max;
    }
}