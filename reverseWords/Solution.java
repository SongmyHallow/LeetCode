// Given an input string, reverse the string word by word.
public class Solution {
    public String reverseWords(String s) {
        if(s==null)
            return s;
        char[] a = s.toCharArray();
        int n = a.length;

        // reverse the whole string
        reverse(a, 0, n-1);
        // reverse each word
        reverseWords(a, n);
        // clean up spaces
        return cleanSpaces(a, n);
    }

    void reverseWords(char[] a, int n){
        int i=0, j=0;
        while(i < n){
            while(i<j || i<n && a[i]==' ')  i++;
            while(j<i || j<n && a[j]!=' ')  j++;
            reverse(a, i, j-1);
        }
    }

    String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;
          
        while (j < n) {
          while (j < n && a[j] == ' ') j++;             // skip spaces
          while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
          while (j < n && a[j] == ' ') j++;             // skip spaces
          if (j < n) a[i++] = ' ';                      // keep only one space
        }
      
        return new String(a).substring(0, i);
    }

    private void reverse(char[] a, int i, int j){
        while(i<j){
            char temp = a[i];
            a[i++] = a[j];
            a[j--] = temp;
        }
    }

    public static void main(String[] args) {
        String s = "  hello world!  ";
        Solution sol = new Solution();
        System.out.println(sol.reverseWords(s));
    }
}