package algorithm;

import common.BinaryTreeUtil;
import common.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LRK
 * @project_name Offer
 * @package_name algorithm
 * @date 2019/4/4 12:57
 * @description God Bless, No Bug!
 *
 * 1. 给定一个二叉搜索树的根结点 root, 返回
 * 树中任意两节点的差的最小值。
 * 示例：
 *  输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意， root 是树结点对象(TreeNode object)，而不是数组。
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *       4
 *      / \
 *      2 6
 *     / \
 *     1 3
 * 最小的差值是 1, 它是节点 1 和节点 2 的差值, 也是节点 3 和
 * 节点 2 的差值。
 */
public class _02LevelTraverse {

    public static void main(String[] args) {

        int[] pre = {4,2,1,3,6};
        int[] in = {1,2,3,4,6};
        TreeNode root = BinaryTreeUtil.constructBinaryTree(pre,in);
        System.out.println("节点之差的最小值: "+new _02LevelTraverse().levelTraverse(root));
    }

    /**
     * 层序遍历求出二叉搜索树节点之差的最小值
     *  最小值只能在中序遍历相邻节点产生,即与子节点之差
     * @param root
     * @return
     */
    public int levelTraverse(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if (temp.left!=null){
                int sub = temp.val - temp.left.val;
                if (sub <min){
                    min = sub;
                }
                queue.offer(temp.left);
            }
            if (temp.right!=null){
                int sub = temp.right.val -temp.val ;
                if (sub <min){
                    min = sub;
                }
                queue.offer(temp.right);
            }
        }
        return min;
    }
}
