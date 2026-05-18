
public class L82 {

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
 
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = head;

        curr = curr.next;
        if (prev.val==curr.val) {
            while (curr != null && prev.val == curr.val) {
                curr = curr.next;
                prev = prev.next;
            }
            head=prev.next;
        }

        while (curr!=null&&curr.next != null) {
            if (curr.next.val == curr.val && head.val == head.next.val) {
                while (curr.next != null&&curr.next.val == curr.val) {
                    curr.next = curr.next.next;
                }
                curr = curr.next;
                prev.next = curr;
                head = head.next;
            }
            

            else if (curr.next.val == curr.val) {
                while (curr.next != null&&curr.next.val == curr.val) {
                    curr.next = curr.next.next;
                }
                curr = curr.next;
                prev.next = curr;
            } else {
                curr = curr.next;
                prev = prev.next;
            }
        }
        
        return head;
    }
}
