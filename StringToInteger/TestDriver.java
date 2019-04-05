package StringToInteger;

public class TestDriver {
    public static void main(String[] args) {
        MySolution test = new MySolution();
        int sol = test.myAtoi("-0012a42");
        System.out.println(sol);
       }
}
