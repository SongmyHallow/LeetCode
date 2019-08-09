import java.util.ArrayList;
import java.util.*;

public class SolutionBT {
    
    public List<String> readBinaryWatch(int num) {
        List<String> sol = new ArrayList<>();
        String empty = "0000000000";

        this.backtrack(sol, empty.toCharArray(), num, 0);
        return sol;
    }

    private void backtrack(List<String> list, char[] chars, int k, int start){
        if(k==0){
            String timeSeq = String.valueOf(chars);
            // use valueOf to convert into integer as 二进制
            String hour = Integer.valueOf(timeSeq.substring(0,4),2).toString();

            Integer minTmp = Integer.valueOf(timeSeq.substring(4),2);
            String min = minTmp < 10 ? "0" + minTmp.toString() : minTmp.toString();

            list.add(hour+":"+min);
            return;
        }
        
        for(int i=start; i<chars.length; i++){
            chars[i] = '1';

            String checkTime = String.valueOf(chars);
            Integer checkHour = Integer.valueOf(checkTime.substring(0,4),2);
            Integer checkMin = Integer.valueOf(checkTime.substring(4),2);

            if(checkHour <= 11 && checkMin <= 59){
                this.backtrack(list, chars, k-1, i+1);
            }
            chars[i] = '0';
        }
    }
}