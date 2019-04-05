package ReplaceSpace;

public class MySolution {
    public String replaceSpace(StringBuffer str) {
        String sol = "";
        int index = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == ' ') {
                sol = sol + str.substring(index, i) + "%20";
                index = i+1;
            }
        }
        sol = sol + str.substring(index, str.length());
        return sol;
    }
}
