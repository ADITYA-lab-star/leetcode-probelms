import java.util.HashMap;

public class L138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //uses O(n)--space
    public Node copyRandomList(Node head) {
        Node temp = head;

        HashMap<Node, Node> map = new HashMap<>();
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }

    public Node copyRandomLis(Node head) {
        Node temp = head;

        while (temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = newNode.next;
        }

        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        temp = head;
        Node newHead = new Node(0);
        Node newTemp = newHead;
        while (temp != null) {
            newTemp.next = temp.next;
            newTemp = newTemp.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }

        return newHead.next;
    }
}
