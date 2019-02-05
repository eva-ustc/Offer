package chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LRK
 * @project_name Offer
 * @package_name chapter4
 * @date 2019/2/5 20:16
 * @description God Bless, No Bug!
 *  字符串的排列组合,递归的运用
 */
public class Sub38_StringPermutation {
    public static void main(String[] args) {
        System.out.println("abc的排列: "+Permutation("abc"));
        System.out.println("abc的组合:");
        combination("abc");
    }

    /**
     * 求字符串的排列
     * @param str
     * @return
     */
    public static ArrayList<String> Permutation(String str) {

        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() <= 0) return list;

        char[] chars = str.toCharArray();
        permutation(chars, 0, list);
        Collections.sort(list);
        return list;
    }

    private static void permutation(char[] chars, int index, ArrayList<String> list) {

        if (index == chars.length - 1) {
            // 得到一个排列
            list.add(new String(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {

            if (!set.contains(chars[i])) {
                set.add(chars[i]);
                // 固定index字符
                swap(chars, i, index);
                // 递归固定剩余字符
                permutation(chars, index + 1, list);
                // 恢复原数组
                swap(chars, i, index);
            }
        }
    }

    /**
     * 求字符串的组合
     * @param str
     * @return
     */
    public static void combination(String str){
        if (str==null || str.length()==0) return;

        StringBuilder builder = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = 1; i <= chars.length; i++) {

            combination(chars,0,i,builder);
        }
    }

    private static void combination(char[] chars, int start, int m, StringBuilder builder) {

        if (m==0){ // 从剩余的字符串中选出0个,表示已经选出m个,递归结束
            System.out.println(builder.toString());
            return;
        }
        if (start == chars.length){
            return;
        }
        builder.append(chars[start]);
        combination(chars,start+1,m-1,builder);
        builder.deleteCharAt(builder.length()-1);
        combination(chars,start+1,m,builder);
    }

    private static void swap(char[] chars, int i, int j) {
        Character temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
