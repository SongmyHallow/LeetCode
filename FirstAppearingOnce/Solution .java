package FirstAppearingOnce;
public class Solution{
    // Simulate a hash array
    int[] hash = new int[256];
    StringBuilder str = new StringBuilder();
    // insert char from stream
    public void Insert(char ch){
        str.append(ch);
        hash[ch]++;
    }

    public char FirstAppearingOnce(){
        for(char s: str.toString().toCharArray()){
            if(hash[s]==1){
                return s;
            }
        }
        return "#";
    }
}