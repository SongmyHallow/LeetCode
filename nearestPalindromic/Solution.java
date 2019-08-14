import java.util.Arrays;

/**
 * Given an integer n, find the closest integer (not including itself), 
 * which is a palindrome.
 * 
 * The 'closest' is defined as absolute difference minimized between 
 * two integers.
 */
public class Solution {
    /**
     * case 1. <= 10, OR equal to 100, 1000, 10000, ... We simply decrease n by 1.
     * case 2. 11, 101, 1001, 10001, 100001, ... We simply decrease n by 2.
     * case 3. 99, 999, 9999, 99999, ... We simply increase n by 2.
     * @param n
     * @return
     */
    public String nearestPalindromic(String n) {
        Long number = Long.parseLong(n);
        Long big = findHigherPalindrome(number+1);
        Long small = findLowerPalindrome(number-1);
        return Math.abs(number - small) > Math.abs(big - number) ? String.valueOf(big):String.valueOf(small);
    }

    public Long findHigherPalindrome(Long limit){
        String n = Long.toString(limit);
        char[] s = n.toCharArray(); // limit
        int m = s.length;
        char[] t = Arrays.copyOf(s, m); // target

        // 翻转前半段
        for(int i=0; i<m/2; i++)
            t[m - 1 - i] = t[i];
        // 和原数比对
        for(int i=0; i<m; i++){
            if(s[i] < t[i]){
                return Long.parseLong(String.valueOf(t));
            }
            else if(s[i] > t[i]){
                for(int j=(m-1)/2; j>=0; j--){
                    if(++t[j] > '9')
                        t[j] = '0';
                    else
                        break;
                }
                // make it palindrome again
                for (int k = 0; k < m / 2; k++) {
                    t[m - 1 - k] = t[k];
                }
                return Long.parseLong(String.valueOf(t));
            }
        }
        return Long.parseLong(String.valueOf(t));
    }

    public Long findLowerPalindrome(Long limit){
        String n = Long.toString(limit);
        char[] s = n.toCharArray();
        int m = s.length;
        char[] t = Arrays.copyOf(s, m);

        for(int i=0; i < m/2; i++){
            t[m - 1 -i] = t[i];
        }

        for(int i=0; i<m; i++){
            if(s[i] > t[i]){
                return Long.parseLong(String.valueOf(t));
            }
            else if(s[i] < t[i]){
                for(int j=(m-1)/2; j>=0; j--){
                    if(--t[j]<'0')
                        t[j] = '9';
                    else
                        break;
                }

                if(t[0] == '0'){
                    char[] a =new char[m-1];
                    Arrays.fill(a, '9');
                    return Long.parseLong(String.valueOf(a));
                }

                // make it palindrome again
                for (int k = 0; k < m / 2; k++) {
                    t[m - 1 - k] = t[k];
                }

                return Long.parseLong(String.valueOf(t));
            }
        }
        return Long.parseLong(String.valueOf(t));
    }

    public static void main(String[] args) {
        String s = "12340";
        Solution sol = new Solution();
        System.out.println(sol.nearestPalindromic(s));
    }
}