package uqam.inf5153.game;

import uqam.inf5153.game.managers.DeckManager;
import uqam.inf5153.game.managers.RoundManager;
import uqam.inf5153.game.modeles.Board;
import uqam.inf5153.game.modeles.Placable;
import uqam.inf5153.game.modeles.PlayerBoard;
import uqam.inf5153.game.modeles.Plot;

import java.util.ArrayList;
import java.util.List;


public class Game {

	private RoundManager roundManager;
	private DeckManager deckManager;
	
	private List<PlayerBoard> playerBoards;
	private Board board;
	
	public Game()
	{
		this.roundManager = new RoundManager();
		this.deckManager = new DeckManager();
		this.playerBoards = new ArrayList<PlayerBoard>();
		this.board = new Board();
	}

	public boolean placePlot(Plot element, double x, double y){
		return board.placePlot(element,x,y);
	}
	public boolean placeWaterChannel(double x, double y){
		return board.placeWaterChannel(x,y);
	}
}
