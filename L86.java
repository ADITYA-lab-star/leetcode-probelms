public class L86 {

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

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        } 
        ListNode tail = head;
        ListNode curr = head;
        ListNode prev = new ListNode(0, head);
        int n = 0;

        while (tail.next != null) {
            n++;
            tail = tail.next;
        }

        for (int i = 0; i < n+1; i++) {
            if (curr != null && curr.val >= x) {
                if (curr==head) {
                    head = head.next;
                }
                tail.next = curr;
                prev.next = prev.next.next;
                tail = tail.next;
                curr.next = null;
                if (prev!=null) {
                    curr = prev.next;
                }
                
            } else {
                curr = curr.next;
                prev = prev.next;
            }
        }
        return head;
    }
}
