/**
 * The TrickOrTreater class represents a participant in the Halloween festivities.
 * @author mpaulus7
 * @version 10.24
 */
public abstract class TrickOrTreater implements Comparable<TrickOrTreater> {
    private String name; // The name of the TrickOrTreater
    private int age; // The age of the TrickOrTreater
    private int numCandy; // The number of candies in the TrickOrTreater's basket

    /**
     * Constructs a TrickOrTreater with specified name, age, and initial candy count.
     *
     * @param name The name of the TrickOrTreater.
     * @param age The age of the TrickOrTreater.
     * @param numCandy The initial candy count of the TrickOrTreater.
     */
    public TrickOrTreater(String name, int age, int numCandy) {
        this.name = (name != null && !name.trim().isEmpty()) ? name : "Charlie Brown";
        this.age = (age >= 0 && age <= 12) ? age : 8;
        this.numCandy = (numCandy >= 0) ? numCandy : 0;
    }

    /**
     * Constructs a default TrickOrTreater named "Charlie Brown" with default age and no candy.
     */
    public TrickOrTreater() {
        this("Charlie Brown", 8, 0);
    }

    /**
     * Adds candies to the TrickOrTreater's basket.
     *
     * @param candyAmt The number of candies to be added.
     */
    protected void gainCandy(int candyAmt) {
        numCandy += candyAmt;
    }

    /**
     * Attempts to deduct candies from the TrickOrTreater's basket.
     *
     * @param candyAmt The number of candies to be deducted.
     * @return The actual number of candies deducted.
     */
    protected int loseCandy(int candyAmt) {
        int lostCandy = (numCandy - candyAmt >= 0) ? candyAmt : candyAmt + (numCandy - candyAmt);
        numCandy -= lostCandy;
        return lostCandy;
    }

    /**
     * Returns a formatted String representing the TrickOrTreater's attributes.
     *
     * @return A formatted String in the format "name/age/numCandy".
     */
    @Override
    public String toString() {
        return String.format("%s/%d/%d", name, age, numCandy);
    }

    /**
     * Compares the TrickOrTreater to another TrickOrTreater based on candy count and age.
     *
     * @param other The TrickOrTreater to compare to.
     * @return An int as defined in the Comparable API.
     */
    @Override
    public int compareTo(TrickOrTreater other) {
        if (this.numCandy != other.numCandy) {
            return Integer.compare(other.numCandy, this.numCandy);
        }
        return Integer.compare(this.age, other.age);
    }

    /**
     * Gets the number of candies in the TrickOrTreater's basket.
     *
     * @return The number of candies in the TrickOrTreater's basket.
     */
    public int getNumCandy() {
        return numCandy;
    }

    /**
     * Represents the action of trick-or-treating. This method is to be implemented by subclasses.
     */
    public abstract void trickOrTreat();
}
