package chapter2;

import java.util.Stack;

/**
 * @author LRK
 * @project_name Offer
 * @package_name chapter2
 * @date 2019/1/31 14:49
 * @description God Bless, No Bug!
 */
public class Sub09_1QueueWithTwoStacks {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        MyQueue queue = new MyQueue();
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.poll());
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue.poll());
        queue.offer(5);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
class MyQueue{
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    /**
     * 入队
     */
    public void offer(Integer value){
        stack1.push(value);
    }

    /**
     * 出队
     * @return
     */
    public Integer poll(){
        if (!stack2.empty()){
            return stack2.pop();
        }else if (stack1!=null){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else {
            throw new IllegalArgumentException("队列为空!");
        }
    }
}
