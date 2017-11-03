public class Player {
    private String playerName;
    private int Brains;
    public void enterName (String player)
    {
        playerName= player;

    }
    public void addBrains (int moreBrains){
        Brains = Brains + moreBrains;
    }
    public String getName(){
        return playerName;
    }
    public int getBrains(){
        return Brains;
    }
}

