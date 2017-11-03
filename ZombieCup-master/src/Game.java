import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        boolean playAgain = true;
        while (playAgain){
            game(scanner);
            System.out.println("Would you like to play again?(yes/no)");
            if(scanner.nextLine().equalsIgnoreCase("yes"))
                playAgain=true;
            else
                playAgain=false;
        }


    }
    public static void game(Scanner scanner){
        System.out.println("Welcome to Zombie Dice!");
        System.out.println("Please enter the number of players.");
        int numPlayers=Integer.parseInt(scanner.nextLine());
        Player[] players = new Player[numPlayers];


        for(int i=0;i<numPlayers;i++){
            System.out.println("Player " + (i+1)+" enter your name.");
            players[i]=new Player();
            players[i].enterName(scanner.nextLine());
        }
        boolean winner = false;
        ArrayList<Player> winners=new ArrayList<Player>();
        while(!winner){
            for(int i=0;i<numPlayers;i++){
                turnOrder(players[i],scanner,i);
                if(players[i].getBrains()>=13){
                    winner=true;
                    winners.add(players[i]);
                }
                System.out.println();
            }
        }
        if(winners.size()==1){
            System.out.println("The winner is "+winners.get(0).getName());
        }else {
            ArrayList<Player> highest=new ArrayList<Player>();
            highest.add(winners.get(0));
            for(int i=1;i<winners.size();i++){
                if(highest.get(0).getBrains()<winners.get(i).getBrains()){
                    highest.clear();
                    highest.add(winners.get(i));
                }
                else if((highest.get(0).getBrains()==winners.get(i).getBrains()))
                    highest.add(winners.get(i));
            }
            if(highest.size()==1)
                System.out.println("The winner is "+highest.get(0).getName());
            else{
                System.out.print("The winners are ");
                for(int i=0;i<highest.size();i++)
                    System.out.print(highest.get(i).getName()+" ");
            }
        }
    }
    public static void turnOrder(Player player, Scanner scanner, int n) {
        System.out.println(player.getName()+" it's your turn");

        ZombieCup cup = new ZombieCup();
        String color = "";
        String value = "";
        int dice = 3;
        int brains = 0;
        int footprints = 0;
        int shotgun = 0;
        String[] colorSend = new String[3];
        turninfo gameturn = new turninfo();
        while(true) {
            String[][] zombcup = cup.zombCup(3);
            for (int i = 0; i < dice; i++) {
                for (int j = 0; j < 2; j++) {
                    if (zombcup[i][j].equalsIgnoreCase("brains")) {
                        System.out.print(zombcup[i][j]);
                        brains++;
                    } else if (zombcup[i][j].equalsIgnoreCase("footprints")) {
                        System.out.print(zombcup[i][j]);
                        colorSend[i] = zombcup[i][0];
                        footprints++;
                    } else if (zombcup[i][j].equalsIgnoreCase("shotgun")) {
                        System.out.print(zombcup[i][j]);
                        shotgun++;
                    } else
                        System.out.print(zombcup[i][j] + " - ");

                }
                System.out.println();
            }
            System.out.println("Brains: " + brains);
            System.out.println("Footprints: " + footprints);
            System.out.println("Shotgun: " + shotgun);
            if (shotgun >= 3) {
                System.out.println("You've been shot! Turn ending.");
                break;
            }
            System.out.println("Roll again or stop? 1 for Roll, 2 for Stop");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 2)
                break;
            footprints=0;
        }
        if(shotgun<3)
            player.addBrains(brains);

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

