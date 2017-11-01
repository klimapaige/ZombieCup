import java.util.Random;

public class Die {
    static Random numGen = new Random();

    public static String dieGreen (){
        int roll = numGen.nextInt(99);
        String dieShows = "";
        if (roll <= 49){
            dieShows = "Brains";
        }else if (roll > 49 && roll < 82){
            dieShows = "FootPrints";
        }else if (roll > 82){
            dieShows = "Shotgun";
        }
        return dieShows;
    }

    public static String dieYellow (){
        int roll = numGen.nextInt(99);
        String dieShows = "";
        if (roll <= 32){
            dieShows = "Brains";
        }else if (roll > 32 && roll < 66){
            dieShows = "FootPrints";
        }else if (roll > 66){
            dieShows = "Shotgun";
        }
        return dieShows;
    }
    public static String dieRed (){
        int roll = numGen.nextInt(99);
            String dieShows = "";
        if (roll <= 49){
            dieShows = "Shotgun";
        }else if (roll > 49 && roll < 82){
            dieShows = "FootPrints";
        }else if (roll > 82){
            dieShows = "Brain";
        }
            return dieShows;
        }
}
//a.	Green (Easy) – 46% chance of spawning; has three brains, two footprints, and one shotgun blast.
//b.	Yellow (Medium) – 31% chance of spawning; has two brains, two footprints, and two shotgun blasts.
//c.	Red (Hard) – 23% chance of spawning; has one brain, two footprints, and three shotgun blasts.
