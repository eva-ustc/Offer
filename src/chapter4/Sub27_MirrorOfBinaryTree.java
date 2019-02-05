package chapter4;

import common.TreeNode;

/**
 * @author LRK
 * @project_name Offer
 * @package_name chapter4
 * @date 2019/2/3 13:12
 * @description God Bless, No Bug!
 */
public class Sub27_MirrorOfBinaryTree {

    public void Mirror(TreeNode root) {

        if (root==null) return;
        if (root.left==null && root.right==null) return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left!=null){
            Mirror(root.left);
        }
        if (root.right!=null){
            Mirror(root.right);
        }
    }
}
