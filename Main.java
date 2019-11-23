import java.util.Scanner;

public class Main {

    private float saberfishcost;
    private float skulkercost;
    private float resources;

    public static void main (String args[]) {
        Main main = new Main();
        main.menu();
    }

    public void menu() {
        boolean finished = false;
        while (!finished) {
            Scanner in = new Scanner(System.in);

            System.out.println("Enter cost of 'Crescent Saberfish Flesh'");
            saberfishcost = in.nextFloat();

            System.out.println("Enter cost of 'Jawless Skulker Flesh'");
            skulkercost = in.nextFloat();

            System.out.println("Enter your Garrison Resources count");
            resources = in.nextFloat();

            calculate();

            Scanner instring = new Scanner(System.in);
            System.out.println("Done? 'y/n'");
            String done = (instring.nextLine().toLowerCase());
            switch(done) {
                case "y": case "yes":
                    finished = true;
                    break;
                case "n": case "no":
                    break;
            }
        }
    }

    public void calculate() {
        float totalcost = skulkercost+saberfishcost;

        float saberfishpercent = saberfishcost/totalcost;
        float skulkerpercent = skulkercost/totalcost;

        float saberfishspendfloat = saberfishpercent*resources;
        float skulkerspendfloat = skulkerpercent*resources;
        int saberfishspend = roundDown(saberfishspendfloat, saberfishcost);
        int skulkerspend = roundDown(skulkerspendfloat, skulkercost);

        int saberfishcostint = (int) saberfishcost;
        int skulkercostint = (int) skulkercost;
        int saberfishamount = saberfishspend/saberfishcostint;
        int skulkeramount = skulkerspend/skulkercostint;

        System.out.println("Buy " + saberfishamount + " 'Crescent Saberfish Flesh' for " + saberfishcostint*saberfishamount + " resources.");
        System.out.println("Buy " + skulkeramount + " 'Jawless Skulker Flesh' for " + skulkercostint*skulkeramount + " resources.");
    }

    public int roundDown(float spendfloat, float multiple) {
        float x = spendfloat/multiple;
        int xint = (int) x;

        int multipleint = (int) multiple;
        int spendint = xint*multipleint;
        return spendint;
    }
}
