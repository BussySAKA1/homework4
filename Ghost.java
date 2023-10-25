public class Ghost extends TrickOrTreater {
    private int robberiesConducted;

    public Ghost(String name, int age, int numCandy) {
        super(name, age, numCandy);
        this.robberiesConducted = 0;
    }

    public Ghost() {
        super("Casper the Unfriendly Ghost", 12, 0);
        this.robberiesConducted = 0;
    }

    public void trickOrTreat() {
        System.out.println("Boo! Trick or treat!");
        gainCandy(2);

    }
    
    public void rob(TrickOrTreater robbed) {
        if (robbed instanceof Robbable) {
            int stolenCandy = ((Robbable) robbed).beRobbed();
            gainCandy(stolenCandy);
            robberiesConducted++;
        }
    }
    
    @Override
    public String toString() {
        return String.format("%s/%d/%d/%d", super.toString(), robberiesConducted);
    }

    @Override
    public int compareTo(TrickOrTreater other) {
        if (other instanceof Ghost) {
            int ghostComparison = super.compareTo(other);
            if (ghostComparison != 0) {
                return ghostComparison;
            } else {
                return Integer.compare(((Ghost) other).robberiesConducted, this.robberiesConducted);
            }
        }
        return super.compareTo(other);
    }
}
