package algorithm;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LRK
 * @project_name Offer
 * @package_name algorithm
 * @date 2019/4/10 19:17
 * @description God Bless, No Bug!
 */
public class _03MinDepth {



    public int minDepth(TreeNode root) {

        if (root == null){
            return 0;
        }
        int dfsMinDepth = getDFSMinDepth(root);
        int bfsMinDepth = getBFSMinDepth(root);
        return dfsMinDepth;

    }

    /**
     * 广度优先遍历(层序遍历),利用队列实现
     * @param root
     * @return
     */
    private int getBFSMinDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cnt = 0;
        while (!queue.isEmpty()){
            cnt++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left==null && tmp.right==null){
                    return cnt;
                }
                if (tmp.left!=null){
                    queue.offer(tmp.left);
                }
                if (tmp.right!=null){
                    queue.offer(tmp.right);
                }
            }
        }
        return cnt;
    }

    /**
     * 深度优先遍历,利用递归
     * @param root
     * @return
     */
    private int getDFSMinDepth(TreeNode root) {
        if (root == null){
            return Integer.MAX_VALUE;
        }
        if (root.left==null && root.right==null){
            return 1;
        }
        int left = getDFSMinDepth(root.left);
        int right = getDFSMinDepth(root.right);

        return Math.min(left,right)+1;
    }
}
