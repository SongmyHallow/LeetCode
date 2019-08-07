/**
 * Given a string, you need to reverse the order of characters 
 * in each word within a sentence while still preserving whitespace 
 * and initial word order.
 */
public class SolutionThree {
    public String simple(String s) {
        if(s==null)
            return s;
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for(String str:words){
            res.append(new StringBuffer(str).reverse().toString()+" ");
        }
        
        return res.toString().trim();
    }

    public String builder(String s){
        if(s==null)
            return s;
        final StringBuilder result = new StringBuilder();
        final StringBuilder word = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!=' '){
                word.append(s.charAt(i));
            }
            else{
                result.append(word.reverse());
                result.append(" ");
                word.setLength(0);
            }
        }
        result.append((word.reverse()));
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        SolutionThree sol = new SolutionThree();
        System.out.println(sol.builder(s));
    }
}