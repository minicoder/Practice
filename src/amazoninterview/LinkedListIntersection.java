package amazoninterview;

/**
 * Created by swetha on 5/10/17.
 */
public class LinkedListIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if( null==headA || null==headB )
            return null;

        ListNode curA = headA, curB = headB;
        while( curA!=curB){
            curA = curA==null?headB:curA.next;
            curB = curB==null?headA:curB.next;
        }
        return curA;
    }

    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
