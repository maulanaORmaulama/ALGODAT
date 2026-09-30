public class Bank{
    public static String bankName = " Bank Dut";
    public static int totalAccounts = 0;
    private int balance;

    public Bank(int balance) {
        this.balance = balance;
        totalAccounts ++;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposit berhasil: Rp " + amount);
        } else {
            System.out.println("Jumlah deposit tidak valid!");
        }
    }

    public static void infoBank(){
        System.out.println(" NAMA BANK :" + bankName);
        System.out.println(" TOTAL AKUN AKTIF : " + totalAccounts);
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Withdraw berhasil: Rp " + amount);
        } else if (amount > this.balance) {
            System.out.println("Saldo tidak mencukupi!");
        } else {
            System.out.println("Jumlah penarikan tidak valid!");
        }
    }

    public int getBalance() {
        return this.balance;
    }
}