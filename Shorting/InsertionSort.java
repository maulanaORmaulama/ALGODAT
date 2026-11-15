public class InsertionSortLinkedList {
    public static Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node sorted = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            sorted = sortedInsert(sorted, current);
            current = nextNode;
        }

        return sorted;
    }

    private static Node sortedInsert(Node sortedHead, Node newNode) {
        if (sortedHead == null || sortedHead.data >= newNode.data) {
            newNode.next = sortedHead;
            sortedHead = newNode;
        } else {
            Node current = sortedHead;
            while (current.next != null && current.next.data < newNode.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        return sortedHead;
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

        head = sort(head);
        System.out.println("Sorted using Insertion Sort:");
        printList(head);
    }
}
