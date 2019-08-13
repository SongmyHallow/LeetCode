public class SolutionTwoGreedy{
    /**
     * Suppose we want to know whether s[i], s[i+1], ..., s[j] form a palindrome. 
     * If i >= j then we are done. If s[i] == s[j] then we may take i++; j--. 
     * Otherwise, the palindrome must be either s[i+1], s[i+2], ..., s[j] or s[i0], 
     * s[i+1], ..., s[j-1], and we should check both cases.
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                int j = s.length()-1-i;
                return (isPalindromeRange(s, i+1, j) ||
                        isPalindromeRange(s, i, j-1));
            }
        }
        return true;
    }
    /**
     * @param s
     * @param i left index
     * @param j right index
     * @return
     */
    public boolean isPalindromeRange(String s, int i, int j){
        for(int k=i; k<=i+(j-i)/2; k++){
            if(s.charAt(k)!=s.charAt(j-k+i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abca";
        SolutionTwoGreedy sol = new SolutionTwoGreedy();
        System.out.println(sol.validPalindrome(s));
    }
}