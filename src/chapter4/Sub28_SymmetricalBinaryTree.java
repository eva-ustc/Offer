package chapter4;

import common.TreeNode;

/**
 * @author LRK
 * @project_name Offer
 * @package_name chapter4
 * @date 2019/2/3 13:34
 * @description God Bless, No Bug!
 */
public class Sub28_SymmetricalBinaryTree {

    boolean isSymmetrical(TreeNode pRoot)
    {
        return isSymmetrical(pRoot,pRoot);
    }

    private boolean isSymmetrical(TreeNode root1, TreeNode root2) {

        if (root1==null && root2==null) return true;
        if (root1==null || root2==null) return false;
        if (root1.val!=root2.val){
            return false;
        }
        return isSymmetrical(root1.left,root2.right)&&isSymmetrical(root2.left,root1.right);
    }
}