package chapter3;

import common.BinaryTreeNode;


/**
 * @author LRK
 * @project_name Offer
 * @package_name chapter3
 * @date 2019/2/2 23:57
 * @description God Bless, No Bug!
 */
public class Sub26_SubStructureInTree {

    public boolean HasSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {
        boolean result = false;
        if (root1 != null && root2!=null){

            if (root1.value == root2.value){
                result = doesHasSubTree(root1,root2);
            }
            if (!result){
                result = doesHasSubTree(root1.leftChild,root2);
            }
            if (!result){
                result = doesHasSubTree(root1.rightChild,root2);
            }
        }
        return result;
    }

    private boolean doesHasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {

        if (root2 == null) return true;
        if (root1 == null) return false;

        if (root1.value != root2.value) return false;


        return doesHasSubTree(root1.leftChild,root2.leftChild) &&
                doesHasSubTree(root1.rightChild,root2.rightChild);
    }
}
