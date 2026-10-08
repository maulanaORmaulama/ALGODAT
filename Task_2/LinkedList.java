class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList<T> {
    private Node<T> head;
    private int size = 0;

    private void updatePosition(T data, int position) {
        if (data instanceof Club) {
            ((Club) data).setPositionClub(position);
        } else if (data instanceof StarPlayer) {
            ((StarPlayer) data).setRankPosition(position);
        }
    }

    private void updateAllPositions() {
        Node<T> current = head;
        int pos = 1;
        while (current != null) {
            updatePosition(current.data, pos);
            current = current.next;
            pos++;
        }
    }

    public void tambahNode(T data) {
        Node<T> nodeBaru = new Node<>(data);
        size++;

        updatePosition(data, size);

        if (head == null) {
            head = nodeBaru;
            System.out.println("Data berhasil ditambahkan sebagai Head.");
            return;
        }

        Node<T> penunjuk = head;
        while (penunjuk.next != null) {
            penunjuk = penunjuk.next;
        }

        penunjuk.next = nodeBaru;
        System.out.println("Data berhasil ditambahkan pada urutan ke-" + size + ".");
    }

    public void hapusNode(T data) {
        if (head == null) {
            System.out.println("List kosong, tidak ada data yang dihapus.");
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            size--;
            updateAllPositions();
            System.out.println("Data berhasil dihapus.");
            return;
        }

        Node<T> penunjuk = head;
        while (penunjuk.next != null && !penunjuk.next.data.equals(data)) {
            penunjuk = penunjuk.next;
        }

        if (penunjuk.next != null) {
            penunjuk.next = penunjuk.next.next;
            size--;
            updateAllPositions();
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("Data tidak ditemukan.");
        }
    }

    public T get(int index) {
        Node<T> penunjuk = head;
        int posisi = 0;

        while (penunjuk != null) {
            if (posisi == index) {
                return penunjuk.data;
            }
            penunjuk = penunjuk.next;
            posisi++;
        }
        return null;
    }

    public void tampilkan() {
        if (head == null) {
            System.out.println("LinkedList kosong.");
            return;
        }

        Node<T> penunjuk = head;
        System.out.print("Isi LinkedList: ");
        while (penunjuk != null) {
            System.out.print(penunjuk.data + " -> ");
            penunjuk = penunjuk.next;
        }
        System.out.println("null");
    }
}