import java.util.*;

// Node definition
class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class DeepCloneLinkedList {

    // ✅ Solution 1: HashMap Method (O(n) space)
    public static Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Node curr = head;

        // Step 1: Create clones of all nodes
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Step 2: Assign next and random pointers
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }

    // ✅ Helper: Print linked list with random pointers
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            int randomVal = (curr.random != null) ? curr.random.val : -1;
            System.out.println("Node(" + curr.val + ") Random -> " + randomVal);
            curr = curr.next;
        }
        System.out.println();
    }

    // ✅ Main for testing
    public static void main(String[] args) {
        // Build sample list: 7 → 13 → 11 → 10 → 1
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;

        // Random pointers
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        System.out.println("Original list:");
        printList(n1);

        Node clone = copyRandomList(n1);

        System.out.println("Cloned list:");
        printList(clone);
    }
}
