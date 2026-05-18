import java.lang.classfile.components.ClassPrinter.ListNode;
import java.util.prefs.BackingStoreException;

public class L92 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode front = head;
        ListNode back = head;
        ListNode t1;
        ListNode t2;
        int c = 0;

        while (front.next != null) {
            if (front.next.val == right) {
                c++;
                break;
            }
            front = front.next;
        }
        while (back.next != null) {
            if (back.next.val == left) {
                c++;
                break;
            }
            back = back.next;
        }

        if (c != 2) {
            return head;
        }
        
        t1 = front.next;
        t2 = back.next;
        front.next = t2;
        back.next = t1;
        front.next.next = t1.next;
        back.next.next = t2.next;

        
        return head;
    }
}
