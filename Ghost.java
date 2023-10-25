/**
 * The Ghost class represents a mischievous trick-or-treater.
 * @author mpaulus7
 * @version 10.24
 */
public class Ghost extends TrickOrTreater {
    private int robberiesConducted;

    /**
     * Constructs a Ghost with the specified name, age, and initial candy count.
     * @param name The name of the Ghost.
     * @param age The age of the Ghost.
     * @param numCandy The initial candy count of the Ghost.
     */
    public Ghost(String name, int age, int numCandy) {
        super(name, age, numCandy);
        this.robberiesConducted = 0;
    }

    /**
     * Constructs a default Ghost named "Casper the Unfriendly Ghost" with default age and no candy.
     */
    public Ghost() {
        super("Casper the Unfriendly Ghost", 12, 0);
        this.robberiesConducted = 0;
    }

    /**
     * Simulates trick-or-treating. The Ghost gains two pieces of candy.
     */
    public void trickOrTreat() {
        System.out.println("Boo! Trick or treat!");
        gainCandy(2);
    }

    /**
     * Attempts to rob another TrickOrTreater.
     * @param robbed The TrickOrTreater to be robbed.
     */
    public void rob(TrickOrTreater robbed) {
        if (robbed instanceof Robbable) {
            int stolenCandy = ((Robbable) robbed).beRobbed();
            gainCandy(stolenCandy);
            robberiesConducted++;
        }
    }

    /**
     * Returns a formatted String representing the Ghost's attributes.
     * @return A formatted String in the format "name/age/numCandy/robberiesConducted".
     */
    @Override
    public String toString() {
        return String.format("%s/%d/%d/%d", super.toString(), robberiesConducted);
    }

    /**
     * Compares the Ghost to another TrickOrTreater, considering robberies conducted.
     * @param other The TrickOrTreater to compare to.
     * @return An int as defined in the Comparable API.
     */
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
