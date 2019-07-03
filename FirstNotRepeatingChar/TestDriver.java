package FirstNotRepeatingChar;
public class TestDriver{
    public static void main(String[] args) {
        String s = "Thisisatest";
        solution sol = new solution();
        int f = sol.FirstNotRepeatingChar(s);
        System.out.println(f);
    }
}