/**
 * p21 Merge Two Sorted Lists
 */
public class P21 {

  public static void main(String args[]) {
    P21 p21 = new P21();
    p21.test();
  }

  public void test() {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    node1.next = node2;
    ListNode node4 = new ListNode(4);
    node2.next = node4;

    ListNode nodeT1 = new ListNode(1);
    ListNode nodeT3 = new ListNode(3);
    nodeT1.next = nodeT3;
    ListNode nodeT4 = new ListNode(4);
    nodeT3.next = nodeT4;

    ListNode result = mergeTwoLists(node1, nodeT1);
    while (null != result) {
      System.out.print(result.val + " ");
      result = result.next;
    }
    System.out.println();
  }


   public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

  /**
   * l2往l1并，如果l2节点小于等于l1节点，则插入在l1节点前面
   * @param l1
   * @param l2
   * @return
   */
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head1 = l1;
    ListNode tmp1Front = new ListNode(0);
    tmp1Front.next = head1;

    ListNode headFinal = tmp1Front;

    ListNode head2 = l2;

    while(head1 != null || head2 != null) {

      if(head1 != null && head2 != null) {
        if(head2.val <= head1.val) {
          ListNode tmp2 = head2;
          head2 = head2.next;
          tmp2.next = head1;
          tmp1Front.next = tmp2;

          tmp1Front = tmp2;
        } else {
          tmp1Front = head1;
          head1 = head1.next;
        }
      } else if(head1 != null && head2 == null) {
        break;
      } else if(head1 == null && head2 != null) {
        tmp1Front.next = head2;
        break;
      }
    }
    return headFinal.next;
  }

}
