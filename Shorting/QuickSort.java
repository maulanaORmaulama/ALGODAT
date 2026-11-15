public class QuickSortLinkedList {
    public static Node getNode(Node head, int index) {
        Node curr = head;
        for (int i = 0; i < index && curr != null; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public static int getLength(Node head) {
        int len = 0;
        Node curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }

    public static Node partition(Node head, int low, int high) {
        Node pivotNode = getNode(head, high);
        int pivot = pivotNode.data;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            Node currJ = getNode(head, j);
            if (currJ.data <= pivot) {
                i++;
                Node currI = getNode(head, i);
                int temp = currI.data;
                currI.data = currJ.data;
                currJ.data = temp;
            }
        }
        Node currI1 = getNode(head, i + 1);
        int temp = currI1.data;
        currI1.data = pivotNode.data;
        pivotNode.data = temp;

        return getNode(head, i + 1);
    }

    public static void sort(Node head, int low, int high) {
        if (low < high) {
            Node pivot = partition(head, low, high);
            int pivotIndex = getIndex(head, pivot);
            sort(head, low, pivotIndex - 1);
            sort(head, pivotIndex + 1, high);
        }
    }

    private static int getIndex(Node head, Node target) {
        int index = 0;
        Node curr = head;
        while (curr != null && curr != target) {
            index++;
            curr = curr.next;
        }
        return index;
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
        Node head = new Node(10);
        head.next = new Node(7);
        head.next.next = new Node(8);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(5);

        int len = getLength(head);
        sort(head, 0, len - 1);
        System.out.println("Sorted using Quick Sort:");
        printList(head);
    }
}
