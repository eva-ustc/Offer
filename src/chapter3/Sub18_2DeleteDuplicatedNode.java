package chapter3;

import common.ListNode;

/**
 * @author LRK
 * @project_name Offer
 * @package_name chapter3
 * @date 2019/2/2 0:20
 * @description God Bless, No Bug!
 */
public class Sub18_2DeleteDuplicatedNode {

    public static void main(String[] args) {

    }

    /**
     * 递归删除
     * @param head
     * @return
     */
    public static ListNode delete(ListNode head){
        if (head==null || head.next==null){
            return head;
        }
        if (head.value == head.next.value){

            if (head.next.next==null){
                return null;
            }
            if (head.value == head.next.next.value){
                return delete(head.next);
            }
        }
        head.next = delete(head.next);
        return head;
    }
    public static ListNode delete2(ListNode head){
        if (head==null || head.next==null){
            return head;
        }
        ListNode pre = null; // 因为头结点也可能重复,所以pre不能初始化为头结点
        ListNode cur = head;
        while (cur!=null){
            if (cur.next!=null && cur.next.value == cur.value){
                int value = cur.value;
                while (cur.next!=null && cur.value==value){
                    cur=cur.next;
                }
                if (pre == null){ // 第一次
                    head = cur.next; // 头结点重复,找到第一个不重复节点作为新的头结点
                }else {
                    pre.next = cur.next;
                }
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
