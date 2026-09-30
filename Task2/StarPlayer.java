public class StarPlayer {
    private String name;
    private int squadNumber;
    private int goalAssist;
    private int trophies;
    private int rankPosition;

    public StarPlayer(String name, int squadNumber, int goalAssist, int trophies) {
        this.name = name;
        this.squadNumber = squadNumber;
        this.goalAssist = goalAssist;
        this.trophies = trophies;
        this.rankPosition = 0;
    }

    public String getName() {
        return name;
    }

    public int getSquadNumber() {
        return squadNumber;
    }

    public int getGoalAssist() {
        return goalAssist;
    }

    public int getTrophies() {
        return trophies;
    }

    public int getRankPosition() {
        return rankPosition;
    }

    public void setRankPosition(int rankPosition) {
        this.rankPosition = rankPosition;
    }

    public void Gacor() {
        System.out.println("Star Player: " + name + " (#" + squadNumber + ")"
                + " | Rank Position: " + rankPosition 
                + " | G/A: " + goalAssist 
                + " | Trophies: " + trophies);
    }

    @Override
    public String toString() {
        return "StarPlayer[Name: " + name + ", #" + squadNumber + ", G/A: " + goalAssist + ", Trophies: " + trophies + ", Pos: " + rankPosition + "]";
    }
}