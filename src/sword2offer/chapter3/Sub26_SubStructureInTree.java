package sword2offer.chapter3;

import common.BinaryTreeNode;
/**
 * @author LRK
 * @project_name Offer
 * @package_name sword2offer.chapter3
 * @date 2019/2/2 23:57
 * @description God Bless, No Bug!
 *
 * 树的子结构
 * 题目描述
 *  输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * 解法
 *  递归方式遍历：
 *
 *      在树A中找到和树B的根结点值一样的结点R
 *      判断树A以R为根结点的子树是否包含与树B一样的结构
 *
 * 这道题的time complexity应该为O(n * m)，其中n为root1的节点数，m为root2的节点数。
 */
public class Sub26_SubStructureInTree {

    public boolean hasSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {
        boolean result = false;
        if (root1 != null && root2!=null){

            if (root1.value == root2.value){
                result = doHasSubTree(root1,root2);
            }
            if (!result){
                result = doHasSubTree(root1.leftChild,root2);
            }
            if (!result){
                result = doHasSubTree(root1.rightChild,root2);
            }
        }
        return result;
    }

    private boolean doHasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {

        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }

        if (root1.value != root2.value) {
            return false;
        }
        return doHasSubTree(root1.leftChild,root2.leftChild) &&
                doHasSubTree(root1.rightChild,root2.rightChild);
    }
}
