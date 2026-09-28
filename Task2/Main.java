import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        boolean berjalan = true;

        while (berjalan) {
            System.out.println("\n==============================");
            System.out.println("     MENU LINKED LIST");
            System.out.println("==============================");
            System.out.println("1. Tambah Data");
            System.out.println("2. Hapus Data");
            System.out.println("3. Cari Data");
            System.out.println("4. Tampilkan Semua Data");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");

            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nilai data yang ingin ditambahkan: ");
                    int dataTambah = scanner.nextInt();
                    list.tambahNode(dataTambah);
                    break;

                case 2:
                    System.out.print("Masukkan nilai data yang ingin dihapus: ");
                    int dataHapus = scanner.nextInt();
                    list.hapusNode(dataHapus);
                    break;

                case 3:
                    System.out.print("Masukkan nilai data yang ingin dicari: ");
                    int dataCari = scanner.nextInt();
                    list.cariNode(dataCari);
                    break;

                case 4:
                    list.tampilkan();
                    break;

                case 5:
                    berjalan = false;
                    System.out.println("Program selesai. Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih angka 1 - 5.");
                    break;
            }
        }

        scanner.close();
    }
}