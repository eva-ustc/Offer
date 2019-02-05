package chapter4;

import java.util.Stack;

/**
 * @author LRK
 * @project_name Offer
 * @package_name chapter4
 * @date 2019/2/3 15:02
 * @description God Bless, No Bug!
 */
public class Sub30_MinInStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (min.empty() || node<=min.peek() ){
            min.push(node);
        }
    }

    public void pop() {
        if (!stack.empty()){
            Integer top = stack.pop();
            if (top == min.peek()){
                min.pop();
            }
        }
    }

    public int top() {
        Integer top = null;
        if (!stack.empty()){

            top = stack.pop();
            if (top == min()){
                min.pop();
            }
        }
        return top;
    }

    public int min() {

        return min.peek();
    }

}
