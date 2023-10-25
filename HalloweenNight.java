public class HalloweenNight {
    private TrickOrTreater[] cryptKickerFive;
    private TrickOrTreater[] ghoulGang;

    public HalloweenNight(TrickOrTreater[] cryptKickerFive, TrickOrTreater[] ghoulGang) {
        this.cryptKickerFive = cryptKickerFive;
        this.ghoulGang = ghoulGang;
    }

    @Override
    public String toString() {
        String returnString = "cryptKickerFive: ";
        for (int i = 0; i < cryptKickerFive.length; i++) {
            if (i != cryptKickerFive.length) {
                returnString += cryptKickerFive[i] + ", ";
            } else {
                returnString += cryptKickerFive[i];
            }
        }
        returnString += " versus ";
        for (int i = 0; i < ghoulGang.length; i++) {
            if (i != ghoulGang.length) {
                returnString += ghoulGang[i] + ", ";
            } else {
                returnString += ghoulGang[i];
            }
        }
        return returnString;
    }

    public void compareTeams() {
        int ckfScore = 0;
        int ggScore = 0;
        for (int i = 0; i < cryptKickerFive.length; i++) {
            if (cryptKickerFive[i].compareTo(ghoulGang[i]) > 0) {
                ckfScore++;
            } else if (cryptKickerFive[i].compareTo(ghoulGang[i]) < 0) {
                ggScore++;
            }
        }
        if (ckfScore > ggScore) {
            System.out.println("cryptKickerFive is favored."); 
        } else if (ckfScore < ggScore) {
            System.out.println("ghouldGand is favored.");
        } else {
            System.out.println("neither team is favored.");
        }
    }

    public void battle(int winningThreshold) {
        winningThreshold = (winningThreshold > 0) ? winningThreshold : 60;

        int cryptKickerCandy = 0;
        int ghoulGangCandy = 0;

        for (int i = 0; i < cryptKickerFive.length; i++) {
            cryptKickerCandy += cryptKickerFive[i].getNumCandy();
            ghoulGangCandy += ghoulGang[i].getNumCandy();
        }

        do {
            for (int i = 0; i < cryptKickerFive.length; i++) {
                cryptKickerFive[i].trickOrTreat();
                if (cryptKickerFive[i] instanceof Ghost) {
                    ((Ghost) cryptKickerFive[i]).rob(ghoulGang[i]);
                }
            }
            for (int i = 0; i < ghoulGang.length; i++) {
                ghoulGang[i].trickOrTreat();
                if (ghoulGang[i] instanceof Ghost) {
                    ((Ghost) ghoulGang[i]).rob(cryptKickerFive[i]);
                }
            }
        } while (cryptKickerCandy < winningThreshold || ghoulGangCandy < winningThreshold);

        if (cryptKickerCandy > ghoulGangCandy) {
            System.out.println("cryptKickerFive won!"); 
        } else if (cryptKickerCandy < ghoulGangCandy) {
            System.out.println("ghouldGand won!");
        } else {
            System.out.println("It is a tie!");
        }
    }
}
