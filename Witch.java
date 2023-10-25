/**
 * The Witch class represents a TrickOrTreater with magical abilities.
 * @author mpaulus7
 * @version 10.24
 */
public class Witch extends TrickOrTreater implements Robbable {
    private String signatureCackle; // The witch's signature cackle

    /**
     * Constructs a Witch with specified name, age, initial candy count, and signature cackle.
     *
     * @param name The name of the Witch.
     * @param age The age of the Witch.
     * @param numCandy The initial candy count of the Witch.
     * @param signatureCackle The Witch's signature cackle.
     */
    public Witch(String name, int age, int numCandy, String signatureCackle) {
        super(name, age, numCandy);
        if (signatureCackle == null || signatureCackle.equals("")) {
            this.signatureCackle = "Bwahaha";
        } else {
            this.signatureCackle = signatureCackle;
        }
    }

    /**
     * Constructs a default Witch named "Maleficent" with age 7 and no candy, and default signature cackle.
     */
    public Witch() {
        super("Maleficent", 7, 0);
        this.signatureCackle = "Bwahaha";
    }

    /**
     * Represents the action of trick-or-treating for a Witch.
     * Acquires two new pieces of candy.
     */
    @Override
    public void trickOrTreat() {
        System.out.printf("%s! I'll get you my pretty!", signatureCackle);
        gainCandy(2);
    }

    /**
     * Compares the Witch to another TrickOrTreater based on candy count, age, and signature cackle length.
     *
     * @param other The TrickOrTreater to compare to.
     * @return An int as defined in the Comparable API.
     */
    @Override
    public int compareTo(TrickOrTreater other) {
        if (other instanceof Witch) {
            int witchComparison = super.compareTo(other);
            if (witchComparison != 0) {
                return witchComparison;
            } else {
                return Integer.compare(((Witch) other).signatureCackle.length(), this.signatureCackle.length());
            }
        }
        return super.compareTo(other);
    }

    /**
     * Allows the Witch to be robbed. The Witch may lose up to six pieces of candy during the robbery.
     *
     * @return The number of candies lost during the robbery.
     */
    @Override
    public int beRobbed() {
        int stolenCandy = Math.min(6, this.getNumCandy());
        this.loseCandy(stolenCandy);
        return stolenCandy;
    }
}
