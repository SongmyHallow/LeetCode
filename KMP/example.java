/**
 * KMP 算法的实现
 */
public class example{
    public static int[] getNext(String modelString){
        int[] next = new int[100];
        next[0] = -1;
        
        int i=0,j=-1;
        while(i < modelString.length()){
            if(j == -1 || modelString.charAt(i)==modelString.charAt(j)){
                i++;
                j++;
                next[i] = j;
            }
            else{
                j = next[j];
            }
        }
        return next;
    }
    /**
     * KMP算法
     * @return 匹配的第一个位置
     * @param next next数组
     * @param modelString 模式串
     * @param mainString 主串
     * */
    public static int KMP(String mainString, String modelString, int[] next){
        int i=0, j=0;
        while(i < mainString.length() && j < modelString.length()){
            if(-1 == j || mainString.charAt(i)==mainString.charAt(j)){
                i++;
                j++;
            }
            else{
                j = next[j];
            }
        }
        //如果最后j到达模式串的尾部,则说明匹配上了
        if(j==modelString.length())
            return i-j;
        else
            return -1;
    }

    public static void main(String[] args) {
        int k = KMP("aababababca","abababca",getNext("abababca"));
        System.out.println(k);
    }
}