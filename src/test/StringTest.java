package test;

/**
 * @author LRK
 * @project_name Offer
 * @package_name chapter2
 * @date 2019/1/30 15:25
 * @description God Bless, No Bug!
 */
public class StringTest {
    public static void main(String[] args) {
        String text = "hello";
        modifyString(text);
        System.out.println(text);
    }

    private static void modifyString(String text) {
        text = "world";
        System.out.println(text);
    }

}
