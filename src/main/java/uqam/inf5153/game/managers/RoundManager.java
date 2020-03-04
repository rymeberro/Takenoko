package uqam.inf5153.game.managers;

public class RoundManager {


    private boolean isLastRound;
    private int countRound;
    private int currentPlayerId;
    private int maxPlayer;

    public RoundManager(int maxPlayer)
    {
        this.isLastRound = false;
        this.countRound = 0;
        this.currentPlayerId = 1;
        this.maxPlayer = maxPlayer;
    }

    /**
     * Passe au prochain joueur
     */
    public void nextPlayer()
    {
        if(this.currentPlayerId >= this.maxPlayer)
        {
            this.nextRound();
            this.currentPlayerId = 0;
        }
        else this.countRound++;
        this.currentPlayerId++;
    }

    /**
     * Passe au prochaine tour
     */
    public void nextRound() { this.countRound++; }

    /**
     * Dit que le prochain tour est le dernier
     */
    public void callLastRound() { this.isLastRound = true; }
    public boolean isLastRound() { return this.isLastRound; }

    public int getCurrentPlayerId() { return this.currentPlayerId; }

    public int getCountRound() { return this.countRound; }
}
