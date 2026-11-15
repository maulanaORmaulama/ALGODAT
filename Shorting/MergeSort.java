public class MergeSortLinkedList {
    public static Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = sort(head);
        Node right = sort(nextOfMiddle);

        Node sortedList = sortedMerge(left, right);
        return sortedList;
    }

    private static Node sortedMerge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node result = null;
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    private static Node getMiddle(Node head) {
        if (head == null) return head;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(12);
        head.next = new Node(11);
        head.next.next = new Node(13);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(6);
        head.next.next.next.next.next = new Node(7);

        head = sort(head);
        System.out.println("Sorted using Merge Sort:");
        printList(head);
    }
}
