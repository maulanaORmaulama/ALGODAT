public class Club {
    private String name;
    private int positionClub;

    public Club(String name) {
        this.name = name;
        this.positionClub = 0;
    }

    public String getName() {
        return name;
    }

    public int getPositionClub() {
        return positionClub;
    }

    public void setPositionClub(int positionClub) {
        this.positionClub = positionClub;
    }

    public void Gacor() {
        System.out.println("Look at the Premier League table: " + name + " is at position " + positionClub);
    }

    @Override
    public String toString() {
        return "Club[Name: " + name + ", Position: " + positionClub + "]";
    }
}