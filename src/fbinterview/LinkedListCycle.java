package fbinterview;

/**
 * Created by swetha on 4/16/17.
 * //Detect a cycle in list and return the node where cycle begins.
 */
public class LinkedListCycle {
    public static void main() {
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        ListNode input;
        //linkedListCycle.detectCycle();
    }

    public ListNode detectCycle(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        boolean hasCycle = false;

        while(fast != null && fast.next!= null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if(!hasCycle) return null;

        fast = A;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
