public abstract class TrickOrTreater implements Comparable<TrickOrTreater> {
    protected String name;
    protected int age;
    protected int numCandy;

    public TrickOrTreater(String name, int age, int numCandy) {
        this.name = (name != null && !name.trim().isEmpty()) ? name : "Charlie Brown";
        this.age = (age >= 0 && age <= 12) ? age : 8;
        this.numCandy = (numCandy >= 0) ? numCandy : 0;
    }

    public TrickOrTreater() {
        this("Charlie Brown", 8, 0);
    }

    protected void gainCandy(int candyAmt) {
        numCandy += candyAmt;
    }

    protected int loseCandy(int candyAmt) {
        int lostCandy = (numCandy - candyAmt >= 0) ? candyAmt : candyAmt + (numCandy - candyAmt);
        numCandy -= lostCandy;
        return lostCandy;
    }

    @Override
    public String toString() {
        return String.format("%s/%d/%d", name, age, numCandy);
    }

    @Override
    public int compareTo(TrickOrTreater other) {
        if (this.numCandy != other.numCandy) {
            return Integer.compare(other.numCandy, this.numCandy);
        }
        return Integer.compare(this.age, other.age);

    }

    public int getNumCandy() {
        return numCandy;
    }

    public abstract void trickOrTreat();
    
}
