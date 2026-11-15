# Sorting Algorithms Implementation using Linked List

**Prepared by:**
* **Name:** Maulana Isna Andika
* **Class:** Informatics Engineering A
* **NIM:** F1D02510072
* **Program:** Bachelor's Degree in Informatics Engineering, Faculty of Engineering, University of Mataram (2026)

---

## A. CODE EXPLANATION

### Node.java

```java
public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```
The code above represents the definition of a `Node` class used as the fundamental building block for the Singly Linked List data structure. It declares a public integer variable `data` to store the numeric value of the element and a `next` pointer to reference the subsequent node in the sequence. The constructor initializes the node by assigning the provided integer value to `data` and explicitly setting the `next` reference to `null`, indicating that it currently points to no other node. You call this internally when constructing or extending a linked list by writing `new Node(data)`. The result is a newly instantiated node object in memory ready to be safely linked into a larger sequence.

---

### BubbleSortLinkedList.java

```java
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
```
The code above represents the `sort` method designed to organize elements within a linked list using the Bubble Sort algorithm. It first checks if the list is empty or contains only a single node, immediately returning `head` if no sorting is required. Inside a `do-while` loop, it traverses the list using a `current` pointer up to a boundary pointer `lptr`, comparing adjacent nodes and swapping their `data` values whenever the current node exceeds the next node. You invoke this method by calling `BubbleSortLinkedList.sort(head)` from your main program. The final result is the modified linked list arranged in ascending order, returning the reference to the head node.

```java
public static void printList(Node head) {
    Node temp = head;
    while (temp != null) {
        System.out.print(temp.data + " ");
        temp = temp.next;
    }
    System.out.println();
}
```
The code above represents the `printList` utility method responsible for displaying the contents of the linked list to the console. It initializes a temporary pointer `temp` at the `head` of the list and iterates sequentially through each node until `temp` reaches `null`. During each iteration, it outputs the node's `data` value followed by a space before advancing the pointer via `temp = temp.next`. You call this method by writing `printList(head)` after performing a sorting operation. The result is a clean, single-line console printout displaying all elements in their current sequential order.

```java
public static void main(String[] args) {
    Node head = new Node(64);
    head.next = new Node(34);
    head.next.next = new Node(25);
    head.next.next.next = new Node(12);
    head.next.next.next.next = new Node(22);
    head.next.next.next.next.next = new Node(11);
    head.next.next.next.next.next.next = new Node(90);

    head = sort(head);
    System.out.println("Sorted Linked List using Bubble Sort:");
    printList(head);
}
```
The code above represents the `main` entry point of the `BubbleSortLinkedList` class used to initialize test data and verify the sorting logic. It manually instantiates and links seven `Node` objects containing unsorted integer values, passes the `head` node into the `sort` method, and prints the resulting sequence to the standard output stream. You do not call this method directly; instead, it executes automatically when you run the compiled class via `java BubbleSortLinkedList`. The ultimate result is the terminal output confirming that the unsorted chain of nodes has been arranged from 11 to 90.

---

### InsertionSortLinkedList.java

```java
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
```
The code above represents the primary `sort` method for the Insertion Sort algorithm on a linked list. It maintains a separate `sorted` list pointer initialized to `null` and iterates through each node of the original list using `current`. Before detaching `current` to insert it into the sorted portion, it safely stores `current.next` in `nextNode` so the traversal path is preserved. You invoke this by writing `head = InsertionSortLinkedList.sort(head)`. The result is a newly ordered chain of nodes where every element has been placed in its exact sorted position, returning the new head of the list.

```java
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
```
The code above represents the `sortedInsert` helper method that handles the placement of a single node into an already sorted linked list. If the sorted list is empty or its head value is greater than or equal to `newNode.data`, it places `newNode` directly at the front; otherwise, it traverses the list using a `while` loop until it finds the exact insertion point. Because it is a `private static` method, it is called internally within `sort` via `sortedInsert(sorted, current)`. The result is an updated sorted sub-list with the new node seamlessly integrated through pointer reassignment.

---

### SelectionSortLinkedList.java

```java
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
```
The code above represents the `sort` method implementing the Selection Sort algorithm over a linked list. For every node pointed to by `current`, it initializes `minNode` to `current` and uses an inner pointer `r` to scan all remaining nodes in search of a smaller `data` value. Once the minimum node in the unsorted remainder is identified, it swaps the integer values between `current` and `minNode` before advancing `current`. You call this method in your application using `SelectionSortLinkedList.sort(head)`. The result is an in-place ascending sort of the linked list values without altering node link structures.

---

### MergeSortLinkedList.java

```java
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
```
The code above represents the recursive `sort` method that applies the Divide and Conquer strategy of Merge Sort to a linked list. It locates the midpoint of the list via `getMiddle(head)` and severs the chain by setting `middle.next = null`, dividing the structure into `left` and `right` halves. It then recursively sorts both halves and combines them using `sortedMerge`. You execute this by calling `head = MergeSortLinkedList.sort(head)`. The final result is a fully sorted linked list achieved with optimal $O(n \log n)$ time complexity and zero auxiliary array overhead.

```java
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
```
The code above represents the `sortedMerge` helper method responsible for recombining two sorted linked lists (`a` and `b`) into a single ordered chain. It compares the `data` values at the heads of both lists, selects the smaller node as `result`, and recursively sets `result.next` to the merged outcome of the remaining nodes. Being a `private static` method, it is invoked internally at the end of each `sort` recursion step. The result is a unified, sorted node sequence constructed purely by re-linking existing node pointers.

```java
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
```
The code above represents the `getMiddle` utility method that finds the center node of a linked list using the two-pointer (tortoise and hare) technique. It advances the `slow` pointer by one step and the `fast` pointer by two steps during each iteration of the `while` loop until `fast` reaches the end of the list. It is called internally within `sort` via `getMiddle(head)`. The result is the exact middle `Node` reference, allowing Merge Sort to split the linked list evenly in a single pass.

---

### QuickSortLinkedList.java

```java
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
```
The code above represents the `partition` method used to rearrange node values around a selected pivot element in Quick Sort. It retrieves the last node in the current range as `pivotNode` using `getNode(head, high)` and iterates from `low` to `high - 1`, swapping node data whenever an element is less than or equal to the pivot. Finally, it places the pivot value into its correct sorted position at index `i + 1`. You invoke this internally from the `sort` method. The result is a partitioned segment where all values preceding the pivot are smaller or equal, and all values following it are greater.

```java
public static void sort(Node head, int low, int high) {
    if (low < high) {
        Node pivot = partition(head, low, high);
        int pivotIndex = getIndex(head, pivot);
        sort(head, low, pivotIndex - 1);
        sort(head, pivotIndex + 1, high);
    }
}
```
The code above represents the recursive `sort` method that coordinates the Quick Sort partitioning process across sub-ranges of the linked list. When `low` is less than `high`, it calls `partition` to position the pivot, determines its logical position via `getIndex`, and recursively invokes `sort` on the left and right partitions. You call this method in your main program using `QuickSortLinkedList.sort(head, 0, len - 1)`. The ultimate result is an in-place sorted linked list ordered through recursive pivot partitioning.

```java
public static Node getNode(Node head, int index) {
    Node curr = head;
    for (int i = 0; i < index && curr != null; i++) {
        curr = curr.next;
    }
    return curr;
}
```
The code above represents the `getNode` helper method designed to simulate index-based access on a Singly Linked List. Starting from `head`, it traverses forward using a `for` loop for a specified number of steps (`index`) and returns the node found at that position. This method is called repeatedly by `partition` to access specific elements during comparisons and swaps. The result is a bridge between index-based sorting logic and pointer-based node traversal.

---

### ShellSortLinkedList.java

```java
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
```
The code above represents the `sort` method implementing Shell Sort on a linked list structure. It calculates the total list length via `getLength(head)` and initializes a `gap` variable to half the list size, halving it on each outer loop iteration. Within the inner loops, it uses `getNode` to compare and shift elements separated by `gap` positions, gradually reducing disorder before performing a final pass with a gap of 1. You execute this by calling `ShellSortLinkedList.sort(head)`. The result is an efficiently sorted linked list that overcomes the slow adjacent-only shifting of standard Insertion Sort.

```java
private static int getLength(Node head) {
    int len = 0;
    Node curr = head;
    while (curr != null) {
        len++;
        curr = curr.next;
    }
    return len;
}
```
The code above represents the `getLength` utility method used to count the total number of nodes present in the linked list. It initializes a counter `len` to 0 and traverses from `head` until `curr` becomes `null`, incrementing `len` at each node. Being a `private static` helper method, it is invoked at the start of `sort` to establish the initial `gap` size. The result is an integer representing the exact size of the linked list.

---

## B. CODE OUTPUT

**1. BubbleSortLinkedList.java**
```text
Sorted Linked List using Bubble Sort:
11 12 22 25 34 64 90
```

**2. InsertionSortLinkedList.java**
```text
Sorted Linked List using Insertion Sort:
5 6 11 12 13
```

**3. SelectionSortLinkedList.java**
```text
Sorted Linked List using Selection Sort:
11 12 22 25 64
```

**4. MergeSortLinkedList.java**
```text
Sorted Linked List using Merge Sort:
5 6 7 11 12 13
```

**5. QuickSortLinkedList.java**
```text
Sorted Linked List using Quick Sort:
1 5 7 8 9 10
```

**6. ShellSortLinkedList.java**
```text
Sorted Linked List using Shell Sort:
2 3 12 34 54
```

---

## C. GITHUB LINK

https://github.com/maulanaORmaulama/ALGODAT