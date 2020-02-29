package uqam.inf5153.game;

import java.util.ArrayList;
import java.util.List;

import uqam.inf5153.game.managers.DeckManager;
import uqam.inf5153.game.managers.RoundManager;
import uqam.inf5153.game.modeles.PlayerBoard;

public class Game {

	private RoundManager roundManager;
	private DeckManager deckManager;
	
	private List<PlayerBoard> playerBoards;

	private static final int MAX_ROUND = 2;

	public Game()
	{
		this.roundManager = new RoundManager(Game.MAX_ROUND);
		this.deckManager = new DeckManager();
		this.playerBoards = new ArrayList<PlayerBoard>();
	}

	/**
	 * Verifie si un joueur a complété suffisament d'objectif pour que ce soit le dernier tour de jeu
	 * @return
	 */
	public boolean verifyEndGame()
	{
		if(this.roundManager.isLastRound()) return true;
		boolean callLastRound = false;
		for(PlayerBoard pb : this.playerBoards)
		{
			if(pb.getCountGoalAchieved() == 9) // Dépends du nombre de joueur
				callLastRound = true;
		}
		if(callLastRound) this.roundManager.callLastRound();
		return callLastRound;
	}
}
