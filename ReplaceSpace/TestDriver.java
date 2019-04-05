package ReplaceSpace;

public class TestDriver {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StringBuffer str = new StringBuffer("We are Happy.");
        MySolution ms = new MySolution();
        String sol = ms.replaceSpace(str);
        System.out.println(sol);
    }

}
