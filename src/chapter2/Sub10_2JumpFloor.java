package chapter2;

/**
 * @author LRK
 * @project_name Offer
 * @package_name chapter2
 * @date 2019/1/31 16:15
 * @description God Bless, No Bug!
 */
public class Sub10_2JumpFloor {

    public static void main(String[] args) {
        Integer result = getFibonacci(3);
        System.out.println(result);
    }

    private static Integer getFibonacci(int target) {

        if (target<=0) return -1;
        if (target<=2) return target;

        int pre = 1;
        int next = 2;
        int result = 0;
        for (int i=3;i<=target;i++){
            result = pre+next;
            pre = next;
            next = result;
        }

        return result;
    }

    /**
     * 变态跳台阶,一次可以跳 1--n级台阶
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }
}
