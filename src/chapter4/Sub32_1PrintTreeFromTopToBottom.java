package chapter4;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author LRK
 * @project_name Offer
 * @package_name chapter4
 * @date 2019/2/3 16:23
 * @description God Bless, No Bug!
 */
public class Sub32_1PrintTreeFromTopToBottom {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
        }
        return list;
    }
    public static ArrayList<ArrayList<Integer>> PrintTreeInLine(TreeNode root) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cnt = 1;
        while (cnt>0){
            int num = cnt;
            cnt = 0;
            ArrayList<Integer> line = new ArrayList<>();
            for (int i = 0; i < num; i++) {

                TreeNode node = queue.poll();
                line.add(node.val);
                if (node.left!=null){
                    cnt++;
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    cnt++;
                    queue.offer(node.right);
                }
            }
            list.add(line);
        }
        return list;
    }

    public static ArrayList<ArrayList<Integer>> printTreeInZigzag(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) return list;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        int level = 1;
        stack1.push(pRoot);
        while (!stack1.empty() || !stack2.empty()){

            if (level%2 == 1 && !stack1.empty()){ // 打印奇数层先压左节点

                ArrayList<Integer> line = new ArrayList<>();
                while (!stack1.empty()){
                    TreeNode node = stack1.pop();
                    line.add(node.val);
                    if (node.left!=null){
                        stack2.push(node.left);
                    }
                    if (node.right!=null){
                        stack2.push(node.right);
                    }
                }
                list.add(line);
                ++level;
            }else if (level%2==0 &&!stack2.empty()){ // 打印偶数层先压右节点
                ArrayList<Integer> line = new ArrayList<>();
                while (!stack2.empty()){

                    TreeNode node = stack2.pop();
                    line.add(node.val);
                    if (node.right!=null){
                        stack1.push(node.right);
                    }
                    if (node.left!=null){
                        stack1.push(node.left);
                    }
                }
                list.add(line);
                ++level;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

        root.left = left;
        root.right = right;
        left.left = four;
        left.right = five;
        right.left=six;
        right.right=seven;
        ArrayList<ArrayList<Integer>> tree = printTreeInZigzag(root);
        for (ArrayList<Integer> list : tree) {
            System.out.println(list);
        }
    }
}
