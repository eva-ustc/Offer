package chapter3;

import java.util.Arrays;

/**
 * @author LRK
 * @project_name Offer
 * @package_name chapter3
 * @date 2019/2/2 16:45
 * @description God Bless, No Bug!
 */
public class Sub21_ReorderArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        reorderArray2(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void reorderArray2(int[] array) {

        int numOfOdd = 0; // 奇数的个数
        for (int num : array) {
            if ((num & 1) == 1) {
                numOfOdd++;
            }
        }
        int[] bak = Arrays.copyOf(array, array.length);
        int index = 0;
        for (int num : bak) {
            if ((num & 1) == 1) {
                array[index++] = num;
            }else {
                array[numOfOdd++] = num;
            }
        }
    }

    private static void reorderArray(int[] array) {

        int len = array.length;
        int pre = 0;
        int last = len - 1;
        while (pre < last) {

            while (pre < last && isOdd(array[pre])) {
                pre++;
            }
            while (pre < last && !isOdd(array[last])) {
                last--;
            }
            if (pre < last) {
                int temp = array[pre];
                array[pre] = array[last];
                array[last] = temp;
            }
        }
    }

    private static boolean isOdd(int num) {

        return (num & 1) == 1;
    }
}
