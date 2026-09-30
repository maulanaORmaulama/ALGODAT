import java.util.Scanner;

public class BankDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to" + Bank.bankName);
        Bank account = new Bank(100000);
        boolean running = true;

        System.out.println("info bank");
        Bank.infoBank();

        while (running) {
            System.out.println("\n==============================");
            System.out.println("MENU BANK" + Bank.bankName);
            System.out.println("1. Cek Saldo (getBalance)");
            System.out.println("2. Deposit (Setor Tunai)");
            System.out.println("3. Withdraw (Tarik Tunai)");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current balance: Rp " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Masukkan jumlah deposit: Rp ");
                    int depositAmount = scanner.nextInt();
                    account.deposit(depositAmount);
                    System.out.println("Current balance: Rp " + account.getBalance());
                    break;
                case 3:
                    System.out.print("Masukkan jumlah withdraw: Rp ");
                    int withdrawAmount = scanner.nextInt();
                    account.withdraw(withdrawAmount);
                    System.out.println("Current balance: Rp " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan" + Bank.bankName);
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }

        scanner.close();
    }
}