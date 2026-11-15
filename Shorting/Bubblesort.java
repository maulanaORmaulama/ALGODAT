public class BubbleSortLinkedList {
    public static Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        boolean swapped;
        Node current;
        Node lptr = null;

        do {
            swapped = false;
            current = head;

            while (current.next != lptr) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
            lptr = current;
        } while (swapped);

        return head;
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
        head.next = new Node(34);
        head.next.next = new Node(25);
        head.next.next.next = new Node(12);
        head.next.next.next.next = new Node(22);
        head.next.next.next.next.next = new Node(11);
        head.next.next.next.next.next.next = new Node(90);

        head = sort(head);
        System.out.println("Sorted using Bubble Sort:");
        printList(head);
    }
}
