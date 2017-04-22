package fbinterview;

/**
 * Created by swetha on 4/16/17.
 * delete dups in list
 */
public class DeleteDupsInList {
    public ListNode deleteDuplicates(ListNode a) {
        ListNode start = a;
        while(a != null && a.next != null) {
            if(a.val == a.next.val) {
                a.next = a.next.next;
                continue;
            }
            a = a.next;
        }
        return start;

    }

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
