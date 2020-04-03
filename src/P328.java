/**
 * p328 Odd Even Linked List
 * 奇数偶数链表
 */
public class P328 {

  public static void main(String args[]) {
    P328 p328 = new P328();
    p328.test();
  }

  public void test() {
    ListNode node = new ListNode(-1);
    ListNode nodeCopy = node;
    int[] list = new int[]{1,2,3,4,5,6,7,8};
    for(int i = 0; i < list.length; i++) {
      node.next = new ListNode(list[i]);
      node = node.next;
    }

    ListNode nodeNew = oddEvenList(nodeCopy.next);
    while (nodeNew != null) {
      System.out.print(nodeNew.val + " ");
      nodeNew = nodeNew.next;
    }
    System.out.println();
  }

  public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }

  public ListNode oddEvenList(ListNode head) {

    if(head == null) return head;
    ListNode odd = head;
    ListNode even = odd.next;
    ListNode evenCopy = even;

    while(odd != null && odd.next != null) {
      // 奇数断开
      even = odd.next;
      odd.next = odd.next.next;
      if(odd.next != null) {
        odd = odd.next;
      }

      // 偶数断开
      if(even.next == null) continue;
      even.next = even.next.next;
    }
    odd.next = evenCopy;
    return head;
  }
}
