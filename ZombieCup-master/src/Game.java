import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }
    public static void game(Scanner scanner){
        Player player1 = new Player();
        Player player2 = new Player();

        System.out.println("Welcome to Zombie Dice!");

        System.out.println("Player 1 enter your name");
        player1.enterName(scanner.nextLine());

        System.out.println("Player 2 enter your name");
        player2.enterName(scanner.nextLine());

        for(int i = 0; i < 0; i++){
            i = i % 2;
            switch (i){
                case 0: turnOrder(player1, scanner, i);
                    break;
                case 1: turnOrder(player2, scanner, i);
                    break;
                default: break;
            }
        }

    }
    public static void turnOrder(Player player, Scanner scanner, int n) {
        System.out.println("Player " +(n+1)+" it's your turn " + player.getName());

        ZombieCup cup = new ZombieCup();
        String color = "";
        String value = "";
        int dice = 3;
        int brains = 0;
        int footprints = 0;
        int shotgun = 0;
        String[] colorSend = new String[3];
        String[][] zombcup = new String[3][2];

        zombcup = cup.zombCup(dice);

        for (int i = 0; i < dice; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(zombcup[i][j]);
                if (zombcup[i][j].equalsIgnoreCase("brains")) {
                    System.out.println(" dice is brains");
                    brains++;
                } else if (zombcup[i][j].equalsIgnoreCase("footprints")) {
                    System.out.println(" dice is footprints");
                    colorSend[i] = zombcup[i][0];
                    footprints++;
                } else if (zombcup[i][j].equalsIgnoreCase("shotgun")) {
                    System.out.println(" dice is shotgun");
                    shotgun++;
                }
            }
        }
        turninfo gameTurn = new turninfo();

        gameTurn.inputInfo (brains, footprints, shotgun, colorSend);

        while (true) {
            System.out.println("Brains: " + brains);
            System.out.println("Footprints: " + footprints);
            System.out.println("Shotgun: " + shotgun);
            if(shotgun >=3){
                System.out.println("You've been shot! Turn ending.");
                return;
            }

            System.out.println("Roll again or stop? 1 for Roll, 2 for Stop");
            int select = scanner.nextInt();

            String[][] dieReroll = new String[footprints][2];
            switch (select) {
                case 1:
                    if (footprints > 0) {
                        for (int l = 0; l < footprints; l++) {
                            dieReroll[l][0] = colorSend[l];

                            dieReroll[l][1] = cup.reRoll(colorSend[l]);
                        }
                    }
                    dice = dice - footprints;
                    footprints = 0;

                    zombcup = new String[dice][2];
                    zombcup = cup.zombCup(dice);



                    gameTurn = diceCheck(zombcup, dieReroll, gameTurn);

                    brains = gameTurn.getBrains();
                    shotgun = gameTurn.getShotgun();
                    footprints = gameTurn.getFootsteps();
                    colorSend = new String[gameTurn.colors.length];
                    colorSend = gameTurn.colors;

                    break;

                case 2:
                    player.addBrains(brains);
                    return;


            }
            System.out.println("Sorry we didn't get that try again.");
        }

    }

    public static turninfo diceCheck (String[][] newDice, String[][] rerollDice, turninfo info){

        String[] colors = new String[3];
        int brains = 0;
        int footprints = 0;
        int shotgun = 0;


        for (int i = 0; i < newDice.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(newDice[i][j]);
                if (newDice[i][j].equalsIgnoreCase("brains")) {
                    System.out.println(" dice is brains");
                    brains++;
                } else if (newDice[i][j].equalsIgnoreCase("footprints")) {
                    System.out.println(" dice is footprints");
                    colors[i + 0] = newDice[i][0];
                    footprints++;
                } else if (newDice[i][j].equalsIgnoreCase("shotgun")) {
                    System.out.println(" dice is shotgun");
                    shotgun++;
                }
            }
        }


        for (int i = 0; i < rerollDice.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(rerollDice[i][j]);
                if (rerollDice[i][j].equalsIgnoreCase("brains")) {
                    System.out.println(" dice is brains");
                    brains++;
                } else if (rerollDice[i][j].equalsIgnoreCase("footprints")) {
                    System.out.println(" dice is footprints");
                    colors[i + rerollDice.length] = rerollDice[i][0];
                    footprints++;
                } else if (rerollDice[i][j].equalsIgnoreCase("shotgun")) {
                    System.out.println(" dice is shotgun");
                    shotgun++;
                }
            }
        }

        info.inputInfo(brains, footprints, shotgun, colors);

        return info;

    }

    private static class turninfo {

        private int brains;
        private int footsteps;
        private int shotgun;
        private String[] colors = new String[3];

        public void inputInfo (int b, int f, int s, String[] colorses){

            brains = b;
            footsteps = f;
            shotgun = s;
            colors = colorses;
        }

        public int getBrains (){

            return brains;
        }
        public int getFootsteps (){

            return footsteps;
        }
        public int getShotgun (){

            return shotgun;
        }
    }

}

