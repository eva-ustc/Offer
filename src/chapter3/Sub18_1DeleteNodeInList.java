package chapter3;

import common.ListNode;

/**
 * @author LRK
 * @project_name Offer
 * @package_name chapter3
 * @date 2019/2/1 23:43
 * @description God Bless, No Bug!
 */
public class Sub18_1DeleteNodeInList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(5);
        deleteNode(head,node);
    }

    private static ListNode deleteNode(ListNode head,ListNode node) {
        if (head==null || node == null) return head;
        // 不是尾节点
        if (node.next!=null){
            // 赋值下一节点的值并删除下一节点
            node.value = node.next.value;
            node.next = node.next.next;

        }else if (node == head){// 链表中只有一个节点
            head = null;
        }else { // 删除尾节点
            /*ListNode dNode = head;
            while (dNode.next!=node){
                dNode=dNode.next;
            }
            dNode.next = null;*/

            node = null;
        }
        return head;
    }

}
