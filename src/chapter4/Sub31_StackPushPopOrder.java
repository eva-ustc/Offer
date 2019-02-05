package chapter4;

import java.util.Stack;

/**
 * @author LRK
 * @project_name Offer
 * @package_name chapter4
 * @date 2019/2/3 15:39
 * @description God Bless, No Bug!
 */
public class Sub31_StackPushPopOrder {


    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int n = pushA.length;
        boolean flag = false; // 判断是否到达数组末尾
        for (int val : popA) {
            while (stack.empty() || stack.peek()!=val){ // 栈为空或者栈顶数字不等于出栈序列
                if (i>=n){ // 已到达末尾
                    flag = true;
                    break;
                }
                stack.push(pushA[i++]);
            }
            if (flag){
                break;
            }
            stack.pop(); // 栈顶数字等于出栈序列的数字
        }
        return stack.empty();
    }
}
