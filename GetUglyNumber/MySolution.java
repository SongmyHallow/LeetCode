package GetUglyNumber;

public class MySolution {
	public int GetUglyNumber_Solution(int index) {
        if(index==1)    return 1;
        int count = 1;
        int head = 2;
        
        while(count<index){
            if(ugly(head)){
                count++;
            } 
            head++;
        }
        return head-1;
    }
    public boolean ugly(int number){
        while(true){
            if(number%2!=0)    break;
            number/=2;
        }
        while(true){
            if(number%3!=0)    break;
            number/=3;
        }
        while(true){
            if(number%5!=0)    break;
            number/=5;
        }
        if(number!=1)    return false;
        else             return true;
    }
}
