public class SolutionDandC{
    public int longestSubstring(String s, int k){
        char[] chars = s.toCharArray();
        return helper(chars, 0, chars.length, k);
    }

    private int helper(char[] chars, int start, int end, int k){
        if(end-start < k)   return 0;
        int[] count = new int[26];
        for(int i=start; i<end; i++){
            int idx = chars[i]-'a';
            count[idx]++;
        }

        for(int i=0; i<26; i++){
            // count[i]=0 => i+'a' does not exist in the string, skip it.
            if(count[i] < k && count[i] > 0){
                for(int j=start; j<end; j++){
                    if(chars[j]==i+'a'){
                        int left = helper(chars, start, j, k);
                        int right = helper(chars, j+1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end-start;
    }
    public static void main(String[] args) {
        String s = "ababbcabacccb";
        int k = 3;
        SolutionDandC sol = new SolutionDandC();
        System.out.println(sol.longestSubstring(s, k));
    }
}