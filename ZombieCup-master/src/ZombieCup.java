public class ZombieCup {

    public static String[][] zombCup(int numDice) {

        String[][] dice = new String[numDice][2];
        int redDie = 23;
        int greenDie = 46 + redDie;
        int yellowDie = 31 + greenDie;

        for (int i = 0; i > numDice; i++) {
            int percent = (int) (Math.random() * 100 + 1);

            if (percent <= redDie) {
                dice[i][0] = "Red";
                Die  die = new Die();
                dice[i][1] = die.dieRed();
            } else if (percent <= greenDie){
                dice[i][0] = "Green";
                Die die = new Die();
                dice[i][1] = die.dieGreen();
            }else if (percent <= yellowDie){
                dice[i][0] = "Yellow";
                Die die = new Die();
                dice[i][1] = die.dieYellow();
            }

        }
        return dice;
    }
    public static String reRoll(String color){

        Die die = new Die();
        if(color.equalsIgnoreCase("Red"))
            return die.dieRed();
        else if(color.equalsIgnoreCase("Yellow"))
            return  die.dieYellow();
        else if(color.equalsIgnoreCase("Green"))
            return die.dieGreen();
        else
            return "";
    }

}