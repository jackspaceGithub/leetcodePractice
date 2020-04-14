/**
 * p876 Middle of the Linked List
 */
public class P876 {

  public static void main(String args[]) {
    P876 p876 = new P876();
    p876.test();
  }


  public void test() {
    ListNode head1 = new ListNode(1);
    ListNode head2 = new ListNode(2);
    head1.next = head2;

    ListNode head3 = new ListNode(3);
    head2.next = head3;

    ListNode head4 = new ListNode(4);
    head3.next = head4;

    ListNode head5 = new ListNode(5);
    head4.next = head5;

    ListNode head6 = new ListNode(6);
    head5.next = head6;

    ListNode result = middleNode(head1);
    System.out.println(result.val);
  }

  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode middleNode(ListNode head) {
      ListNode[] list = new ListNode[101];
      int length = 0;
      while(null != head) {
        list[length++] = head;
        head = head.next;
      }
      return list[length/2];
    }

    // 快慢指针法，如果面试官不允许你设置数组，还不允许你使用计数变量，只能如此了
    public ListNode middleNode2(ListNode head) {
      ListNode slow = head, fast = head;
      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }
      return slow;
    }
}
