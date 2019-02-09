package chapter6;

import common.TreeNode;
import java.util.Stack;

/**
 * @author LRK
 * @project_name Offer
 * @package_name chapter5
 * @date 2019/2/9 17:50
 * @description God Bless, No Bug!
 */
public class Sub55_1TreeDepth {

    public int TreeDepth(TreeNode root) {

        if (root ==null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return left>right?left+1:right+1;
    }


}
