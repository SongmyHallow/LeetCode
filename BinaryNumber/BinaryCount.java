package BinaryNumber;

//Problem description:
//input is a integer, output the number of 1 in the binary expression
//negative number will be turned into compliment number

public class BinaryCount {
    
    public int NumberOf1(int n) {
        
        System.out.println("Input integer is:"+n);
        String output = Integer.toBinaryString(n);
        System.out.println("In binary expression:"+output);
        int counter = 0;
        for(int i=0; i<output.length();i++) {
            char c = output.charAt(i);
            if(c == '1')    counter++;
        }
        
        System.out.print("The number of 1 is:"+counter);
        return counter;
    }
}
