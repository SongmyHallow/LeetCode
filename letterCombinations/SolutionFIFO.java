import java.util.LinkedList;

public class SolutionFIFO{
    public List<String> letterCombinations(String digits){
        LinkedList<String> ans = new LinkedList<>();
        if(digits.isEmpty())
            return ans;
        // use index as phone
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");

        for(int i=0; i<digits.length(); i++){
            // get the value of single digit number
            int x = Character.getNumericValue(digits.charAt(i));
            // add extra digit to current solutions
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s:mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }

}