public class Witch extends TrickOrTreater implements Robbable {
    private String signatureCackle;

    public Witch(String name, int age, int numCandy, String signatureCackle) {
        super(name, age, numCandy);
        if (signatureCackle != null || signatureCackle != "") {
            this.signatureCackle = signatureCackle;
        }
    }

    public Witch() {
        super("Maleficent", 7, 0);
        this.signatureCackle = "Bwahaha";
    }

    @Override
    public void trickOrTreat(){
        System.out.printf("%s! I'll gety you my pretty!", signatureCackle);
        gainCandy(2);
    }

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

    @Override
    public int beRobbed() {
        int stolenCandy = Math.min(6, this.getNumCandy());
        this.loseCandy(stolenCandy);
        return stolenCandy;
    }
}
