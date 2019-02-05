package chapter3;

/**
 * @author LRK
 * @project_name Offer
 * @package_name chapter3
 * @date 2019/2/1 19:56
 * @description God Bless, No Bug!
 */
public class Sub17_Print1ToMaxNDigits {
    public static void main(String[] args) {
        print1ToMax2(3);
    }

    private static void print1ToMax2(int n) {
        char[] num = new char[n];
//        num[n]='\0';
        for (int i = 0; i < 10; i++) {
            num[0] = (char) (i+'0');
            doPrintRecursion(num,n,0);
        }
    }

    private static void doPrintRecursion(char[] num, int len, int index) {

        if (index == len-1){
            doPrint(num);
            return;
        }
        for (int i = 0; i < 10; i++) {
            num[index+1] = (char) (i+'0');
            doPrintRecursion(num,len,index+1);
        }
    }

    private static void print1ToMax(int n) {

        char[] num = new char[n];
        for (int i = 0; i < num.length; i++) {
            num[i] = '0';
        }
        int back = 0;
        while (!increment(num)) {
            back++;
            if (back%10==0) System.out.println();
            doPrint(num);
        }
    }

    /**
     * 打印字符
     * @param num
     */
    private static void doPrint(char[] num) {

        int start = 0;
        while (start<num.length &&num[start]=='0'){
            start++;
        }
        StringBuilder result = new StringBuilder();
        for (int i = start; i < num.length; i++) {
            result.append(num[i]);
        }
        System.out.print(result.toString()+" ");
    }

    /**
     * num+1
     * @param num
     * @return flag: 是否溢出
     */
    private static boolean increment(char[] num) {

        boolean flag = false;
        int inc = 1;

        for (int i = num.length - 1; i >= 0; i--) {

            int res = num[i] - '0' + inc;
            if (res > 9) {
                if (i == 0) {
                    flag = true;
                    break;
                }
                num[i] = '0';
            } else {
                ++num[i];
                break;
            }
        }
        return flag;
    }
}
