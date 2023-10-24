public class TrickOrTreater{
    private String name;
    private int age;
    private int numCandy;

    public TrickOrTreater(String name, int age, int numCandy) {
        this.name = name;
        this.age = age;
        this.numCandy = numCandy;
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

    // @Override
    // public int compareTo() {

    // }

    public int getNumCandy() {
        return numCandy;
    }
    
}