/**
 * Given a non-empty string s, you may delete at most one character.
 * Judge whether you can make it a palindrome.
 */
public class SolutionTwo {
    // 暴力求解
    public boolean validPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            sb.deleteCharAt(i);
            if(checkPalindrome(sb))
                return true;
            sb.insert(i,c);
        }
        return checkPalindrome(s);
    }

    public boolean checkPalindrome(CharSequence s){
        for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abca";
        SolutionTwo sol = new SolutionTwo();
        System.out.println(sol.validPalindrome(s));
    }
}