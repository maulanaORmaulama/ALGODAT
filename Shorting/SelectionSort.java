public class SelectionSortLinkedList {
    public static void sort(Node head) {
        if (head == null) {
            return;
        }

        Node current = head;
        while (current != null) {
            Node minNode = current;
            Node r = current.next;

            while (r != null) {
                if (r.data < minNode.data) {
                    minNode = r;
                }
                r = r.next;
            }

            int temp = current.data;
            current.data = minNode.data;
            minNode.data = temp;

            current = current.next;
        }
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
        Node head = new Node(64);
        head.next = new Node(25);
        head.next.next = new Node(12);
        head.next.next.next = new Node(22);
        head.next.next.next.next = new Node(11);

        sort(head);
        System.out.println("Sorted using Selection Sort:");
        printList(head);
    }
}
