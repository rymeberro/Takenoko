package uqam.inf5153.game.modeles;

import uqam.inf5153.game.modeles.PlayerBoard;
import uqam.inf5153.game.modeles.Plot;
import uqam.inf5153.game.modeles.decks.PlotDeck;

import java.util.ArrayList;
import java.util.List;


public class Player
{
    private int id;
    private String name;
    private int score;
    private PlayerBoard playerBoard;

    public Player()
    {
        this.id = 0;
        this.name = "";
        this.score = 0;
        this.playerBoard = new PlayerBoard();
    }

    public Player(int i_id, String i_name)
    {
        this.id = id;
        this.name = i_name;
        this.score = 0;
        this.playerBoard = new PlayerBoard();
    }

    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public int getScore() { return this.score; }
    public void addScore(int value) { this.score += value; }

    public PlayerBoard getBoard() { return this.playerBoard; }
}
