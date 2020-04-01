/**
 * p206 单链表翻转
 */

public class P206 {

  public static void main(String args[]) {
    P206 p206 = new P206();
    p206.test();
  }

  public void test() {
    ListNode node = new ListNode(1);
//    node.next = new ListNode(2);
//    node.next.next = new ListNode(3);
//    node.next.next.next = new ListNode(4);
//    node.next.next.next.next = new ListNode(5);
    ListNode node1 = reverseList(node);
    while(node1 != null) {
      System.out.print(node1.val + " ");
      node1 = node1.next;
    }
    System.out.println();
  }

  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public ListNode reverseList(ListNode head) {
    ListNode pre = null;
    ListNode now = head;
    ListNode after = null;

    while (head != null) {
      after = head.next;
      head.next = pre;
      pre = head;
      head = after;
    }
    return pre == null ? now : pre;
  }
}
