package chapter3;

/**
 * @author LRK
 * @project_name Offer
 * @package_name chapter3
 * @date 2019/2/2 15:50
 * @description God Bless, No Bug!
 */
public class Sub20_NumericString {

    public static void main(String[] args) {
        boolean flag = isNumber2("6.5e2".toCharArray());
        System.out.println(flag);
    }

    private static int index = 0;
    private static boolean isNumber2(char[] str) {
        if (str==null || str.length==0){
            return false;
        }
        // 判断是否存在整数
        boolean flag = scanInteger(str);

        // 小数部分
        if (index<str.length && str[index]=='.'){
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }
        if (index<str.length && (str[index]=='e' || str[index]=='E')){
            index++;
            flag = scanInteger(str) && flag;
        }
        return flag && index == str.length;
    }

    private static boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index<str.length && str[index]>='0' && str[index]<='9'){
            index++;
        }
        return index>start;
    }

    private static boolean scanInteger(char[] str) {
        while (index<str.length && (str[index]=='+' || str[index]=='-')){
            index++;
        }
        return scanUnsignedInteger(str);
    }

    private static boolean isNumber(char[] str) {

        return str!=null && str.length!=0
                &&new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

}
