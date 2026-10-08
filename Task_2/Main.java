public class Main {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("       LINKED LIST PREMIER LEAGUE");
        System.out.println("=========================================");
        LinkedList<Club> premierLeague = new LinkedList<>();

        Club c1 = new Club("Manchaster United");
        Club c2 = new Club("Manchester City");

        premierLeague.tambahNode(c1);
        premierLeague.tambahNode(c2);
        
        c1.Gacor();
        c2.Gacor();

        System.out.println("\n=========================================");
        System.out.println("        LINKED LIST STAR PLAYER");
        System.out.println("=========================================");
        LinkedList<StarPlayer> playerList = new LinkedList<>();

        StarPlayer p1 = new StarPlayer("Bruno Fernandes", 20, 21, 11);
        StarPlayer p2 = new StarPlayer("Erling Haaland", 9, 52, 6);
        StarPlayer p3 = new StarPlayer("Bukayo Saka", 7, 30, 2);

        System.out.println("=== TAMBAH PEMAIN ===");
        playerList.tambahNode(p1);
        playerList.tambahNode(p2);
        playerList.tambahNode(p3);

        System.out.println("\n=== CEK STATISTIK DAN POSISI PEMAIN ===");
        p1.Gacor();
        p2.Gacor();
        p3.Gacor();

        System.out.println("\n=== HAPUS SALAH (RANK 1) ===");
        playerList.hapusNode(p1);

        System.out.println("\n=== POSISI RANKING PEMAIN SETELAH DIHAPUS ===");
        p2.Gacor();
        p3.Gacor();
    }
}