import java.util.Arrays;

/**
 * Given a string and an integer k, you need to reverse the 
 * first k characters for every 2k characters counting from 
 * the start of the string. If there are less than k characters left, 
 * reverse all of them. If there are less than 2k but greater than 
 * or equal to k characters, then reverse the first k characters and 
 * left the other as original.
 */
public class SolutionTwo{
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for(int start=0; start<a.length; start+=2*k){
            int i = start, j=Math.min(start+k-1, a.length-1);
            while(i<j){
                char temp = a[i];
                a[i++] = a[j];
                a[j--] = temp;
            }
        }
        return new String(a);
    }

    
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        SolutionTwo sol = new SolutionTwo();
        System.out.println((sol.reverseStr(s,k)));
    }

}