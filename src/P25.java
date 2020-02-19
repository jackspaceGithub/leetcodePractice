import java.util.ArrayList;
import java.util.List;

/**
 * 25. Reverse Nodes in k-Group
 * 每k个一组翻转链表
 * 首先单链表翻转需要三个指针，分别指向前中后节点，此题思路我想是在单链表翻转基础上拓展
 */
public class P25 {

    public void main() {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        head1.next = head2;
        ListNode head3 = new ListNode(3);
        head2.next = head3;
        ListNode head4 = new ListNode(4);
        head3.next = head4;
        ListNode head5 = new ListNode(5);
        head4.next = head5;

        reverseKGroup(head1, 2);
        ListNode head = head2;
        while (head.next != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println(head.val);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode count = head;
        int total = 0;
        while(count != null) {
            total++;
            count = count.next;
        }

        if(k > total) return head;

        // n轮翻转
        int n = total / k;
        int i = 1;
        ListNode newHead = null;
        ListNode now = head;

        // 把上一次的尾部节点指向这一次的头部节点, lastTimeTail记录上一次的尾节点
        ListNode lastTimeTail = null;
        while (i <= n){
            List<ListNode> list = reverseSingleLinkListDIY(now , k);
            now = list.get(2);
            if(i == 1) {
                newHead = list.get(0);
            }

            if(lastTimeTail != null) {
                lastTimeTail.next = list.get(0);
            }

            lastTimeTail = list.get(1);
            i++;
        }
        if(lastTimeTail != null) {
            lastTimeTail.next = now;
        }

        return newHead;
    }


    /**
     * 单链表翻转，适配此题目版本
     * 根据间隔k，确定此轮应该翻转的节点有哪些
     * 返回此次翻转后的头尾节点和下一个要用的节点now
     */
    private List<ListNode> reverseSingleLinkListDIY(ListNode head, int k) {
        ListNode pre = null;
        ListNode now = head;
        ListNode after = null;
        int num = 1;

        while (num <= k && now != null){
            // 记录好后继节点
            after = now.next;

            // 断开跟后继节点的联系
            now.next = pre;
            // 前继节点后移一位
            pre = now;
            // 现节点后移一位
            now = after;
            num++;
        }

        // 2,现在head是尾部节点， 1,pre是头部节点, 3,now 是下一个要用的节点
        List<ListNode> list = new ArrayList<>();
        list.add(pre);
        list.add(head);
        list.add(now);
        return list;
    }


    /**
     * 单链表翻转
     */
    private ListNode reverseSingleLinkList(ListNode head) {
        ListNode pre = null;
        ListNode now = head;
        ListNode after;

        while (now != null){
            // 记录好后继节点
            after = now.next;

            // 断开跟后继节点的联系
            now.next = pre;
            // 前继节点后移一位
            pre = now;
            // 现节点后移一位
            now = after;
        }
        return pre;
    }
}
