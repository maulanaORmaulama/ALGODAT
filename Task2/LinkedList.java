class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    private Node head;
    public void tambahNode(int data) {
        Node nodeBaru = new Node(data);

        if (head == null) {
            head = nodeBaru;
            System.out.println("Node " + data + " berhasil ditambahkan sebagai Head.");
            return;
        }

        Node penunjuk = head;
        while (penunjuk.next != null) {
            penunjuk = penunjuk.next;
        }

        penunjuk.next = nodeBaru;
        System.out.println("Node " + data + " berhasil ditambahkan.");
    }
    public void hapusNode(int data) {
        if (head == null) {
            System.out.println("LinkedList kosong, tidak ada data yang dihapus.");
            return;
        }

        if (head.data == data) {
            head = head.next;
            System.out.println("Node " + data + " berhasil dihapus.");
            return;
        }

        Node penunjuk = head;
        while (penunjuk.next != null && penunjuk.next.data != data) {
            penunjuk = penunjuk.next;
        }

        if (penunjuk.next != null) {
            penunjuk.next = penunjuk.next.next;
            System.out.println("Node " + data + " berhasil dihapus.");
        } else {
            System.out.println("Node dengan nilai " + data + " tidak ditemukan.");
        }
    }
    public void cariNode(int data) {
        if (head == null) {
            System.out.println("LinkedList kosong.");
            return;
        }

        Node penunjuk = head;
        int posisi = 1;
        boolean ditemukan = false;

        while (penunjuk != null) {
            if (penunjuk.data == data) {
                System.out.println("Data " + data + " ditemukan pada posisi/urutan ke-" + posisi + ".");
                ditemukan = true;
                break;
            }
            penunjuk = penunjuk.next;
            posisi++;
        }

        if (!ditemukan) {
            System.out.println("Data " + data + " tidak ditemukan dalam LinkedList.");
        }
    }
    public void tampilkan() {
        if (head == null) {
            System.out.println("LinkedList kosong.");
            return;
        }

        Node penunjuk = head;
        System.out.print("Isi LinkedList: ");
        while (penunjuk != null) {
            System.out.print(penunjuk.data + " -> ");
            penunjuk = penunjuk.next;
        }
        System.out.println("null");
    }
}