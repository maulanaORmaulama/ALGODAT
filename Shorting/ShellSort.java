public class ShellSortLinkedList {
    public static void sort(Node head) {
        int n = getLength(head);
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Node currI = getNode(head, i);
                int temp = currI.data;
                int j = i;
                while (j >= gap && getNode(head, j - gap).data > temp) {
                    getNode(head, j).data = getNode(head, j - gap).data;
                    j -= gap;
                }
                getNode(head, j).data = temp;
            }
        }
    }

    private static int getLength(Node head) {
        int len = 0;
        Node curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }

    private static Node getNode(Node head, int index) {
        Node curr = head;
        for (int i = 0; i < index && curr != null; i++) {
            curr = curr.next;
        }
        return curr;
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
        head.next = new Node(34);
        head.next.next = new Node(54);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(3);

        sort(head);
        System.out.println("Sorted using Shell Sort:");
        printList(head);
    }
}
