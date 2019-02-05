package common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author LRK
 * @project_name Offer
 * @package_name common
 * @date 2019/1/30 20:18
 * @description God Bless, No Bug!
 *
 *  二叉树: 前序遍历 中序遍历 后序遍历的非递归实现 层序遍历
 */
public class BinaryTreeUtil {
    /**
     * 前序遍历非递归实现一:
     * 1 输出当前节点p,将其入栈,再看p的左孩子是否为空:
     * 2 若左孩子不为空,则依次输出左子树并入栈,重复直到左孩子为空,
     * 3 左孩子为空,则弹出栈顶结点,并将弹出节点的右孩子作为当前节点判断是否为空
     * 4 若不为空,则循环至1
     * 5 若为空,则继续出栈,同时将出栈节点的右孩子作为当前节点判断是否为空,重复4,5
     * 6 直到当前节点为空并且栈空,遍历结束
     *
     * @param root
     * @return
     */
    public static ArrayList<BinaryTreeNode> preTraverse(BinaryTreeNode root) {
        if (root == null) return null;
        Stack<BinaryTreeNode> stack = new Stack<>();
        ArrayList<BinaryTreeNode> list = new ArrayList<>();
        BinaryTreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) { // 当前节点为空表示所有节点都访问过了
                list.add(current);
                stack.push(current);
                current = current.leftChild;
            }
            if (!stack.isEmpty()) { // 栈为空表示所有入栈节点的右子树都访问过了
                BinaryTreeNode temp = stack.pop();
                current = temp.rightChild;
            }
        }
        return list;
    }

    /**
     * 前序遍历非递归实现二:
     * 1 将根节点入栈
     * 2 当栈不为空时开始循环:
     * 1)弹出栈顶结点p,输出弹出的节点;
     * 2)先将p.rightChild入栈;
     * 3)再将p.leftChild入栈;
     *
     * @param root
     * @return
     */
    public static ArrayList<BinaryTreeNode> preTraverse2(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        ArrayList<BinaryTreeNode> list = new ArrayList<>();
        stack.push(root);
        BinaryTreeNode node = null;
        while (!stack.empty()) {
            node = stack.pop();
            if (node != null) {
                list.add(node);
                stack.push(node.rightChild);
                stack.push(node.leftChild);
            }
        }
        return list;
    }

    /**
     * 中序遍历非递归实现: 和前序实现一类似,只是将打印操作放到出栈时执行
     *   实现思路:
     *      中序遍历是要先遍历左子树，然后跟节点，最后遍历右子树。所以需要先把跟节点入栈然后在一直把左子树入栈
     *      直到左子树为空，此时停止入栈。栈顶节点就是我们需要访问的节点，取栈顶节点p并访问。然后改节点可能有右子树，所以
     *      访问完节点p后还要判断p的右子树是否为空，如果为空则接下来要访问的节点在栈顶，所以将p赋值为null。如果不为空则
     *      将p赋值为其右子树的值。 循环结束的条件是p不为空或者栈不为空。
     * @param root
     * @return
     */
    public static ArrayList<BinaryTreeNode> midTraverse(BinaryTreeNode root) {

        if (root == null) return null;

        BinaryTreeNode current = root;
        Stack<BinaryTreeNode> stack = new Stack<>();
        ArrayList<BinaryTreeNode> list = new ArrayList<>();

        while (current!=null || !stack.empty()){
            while (current!=null){
                stack.push(current);
                current = current.leftChild;
            }
            if (!stack.empty()){
                BinaryTreeNode temp = stack.pop();
                list.add(temp);
                current = temp.rightChild;
            }
        }
        return list;
    }

    /**
     * 后序遍历非递归实现:
     *    要保证根结点在左孩子和右孩子访问之后才能访问，因此对于任一结点P，先将其入栈。
     *         如果P不存在左孩子和右孩子，则可以直接访问它；
     *         或者P存在左孩子或者右孩子，但是其左孩子和右孩子都已被访问过了，则同样可以直接访问该结点。
     *    若非上述两种情况，则将P的右孩子和左孩子依次入栈，这样就保证了每次取栈顶元素的时候，
     *    左孩子在右孩子前面被访问，左孩子和右孩子都在根结点前面被访问。
     * @param root
     * @return
     */
    public static ArrayList<BinaryTreeNode> afterTraverse(BinaryTreeNode root){

        ArrayList<BinaryTreeNode> list = new ArrayList<>();
        if (root == null) return list;
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode current,previous = null;
        stack.push(root);
        while (!stack.empty()){
            current = stack.peek();
            if ((current.leftChild==null && current.rightChild==null)
                    ||(previous!=null &&(previous==current.leftChild || previous == current.rightChild))){
                // 后一条件也可以写为( (previous == current.rightChild) ||
                // (previous== current.leftChild && current.rightChild==null) )
                // 如果是叶子节点或者左右子节点均已访问过,则可以出栈并访问
                BinaryTreeNode temp = stack.pop();
                list.add(temp);
                previous = temp;
            }else {
                // 否则将current的右,左子树依次进栈
                if (current.rightChild!=null){
                    stack.push(current.rightChild);
                }
                if (current.leftChild!=null){
                    stack.push(current.leftChild);
                }
            }
        }
        return list;
    }

    /**
     * 层序遍历,借助队列实现
     * @param root
     * @return
     */
    public static ArrayList<BinaryTreeNode> levelTraverse(BinaryTreeNode root){

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        ArrayList<BinaryTreeNode> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            BinaryTreeNode temp = queue.poll();
            list.add(temp);
            if (temp.leftChild!=null){
                queue.offer(temp.leftChild);
            }
            if (temp.rightChild!=null){
                queue.offer(temp.rightChild);
            }
        }
        return list;
    }

}
