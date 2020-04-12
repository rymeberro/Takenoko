package uqam.inf5153.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import uqam.inf5153.game.managers.DeckManager;
import uqam.inf5153.game.managers.RoundManager;
import uqam.inf5153.game.modeles.*;
import uqam.inf5153.game.modeles.decks.AmenagementsDeck;
import uqam.inf5153.game.modeles.decks.GoalDeck;
import uqam.inf5153.game.modeles.decks.PlotDeck;
import uqam.inf5153.game.modeles.decks.WaterDeck;
import uqam.inf5153.game.modeles.goals.Goal;

public class Game {

	private RoundManager roundManager;
	private DeckManager deckManager;
	
	private List<Player> players;

	private PlotDeck plotDeck;
	private GoalDeck goalDeck;
	private WaterDeck waterDeck;
	private AmenagementsDeck amenagementsDeck;

	private Board board;

	private static final int MAX_ROUND = 2;
	private static final int COUNT_PLAYER = 2;

	public Game()
	{
		this.roundManager = new RoundManager(Game.MAX_ROUND);
		this.deckManager = new DeckManager();
		this.players = new ArrayList<Player>();

		for(int i = 0; i < Game.COUNT_PLAYER; i++)
			this.players.add(new Player(i, "Player " + i));

		this.plotDeck = new PlotDeck();
		this.goalDeck = new GoalDeck();
		this.waterDeck = new WaterDeck();
		this.amenagementsDeck = new AmenagementsDeck();

		this.plotDeck.init();
		this.goalDeck.init();
		this.waterDeck.init();
		this.amenagementsDeck.init();

		this.board = new Board();
	}

	/**
	 * Verifie si un joueur a complété suffisament d'objectif pour que ce soit le dernier tour de jeu
	 * @return
	 */
	public boolean verifyEndGame()
	{
		if(this.roundManager.isLastRound()) return true;
		boolean callLastRound = false;
		for(Player p : this.players)
		{
			if(p.getBoard().getCountGoalAchieved() == 9) // Dépends du nombre de joueur
				callLastRound = true;
		}
		if(callLastRound) this.roundManager.callLastRound();
		return callLastRound;
	}

	public Optional<Plot> pickPlot() { return this.deckManager.pick(this.plotDeck);	}
	public Optional<Goal> pickGoal() { return this.deckManager.pick(this.goalDeck);	}
	public Optional<WaterChannel> pickWaterChannel() { return this.deckManager.pick(this.waterDeck); }

	public RoundManager getRoundManager() { return this.roundManager; }
	public DeckManager getDeckManager() { return this.deckManager; }

	public List<Player> getPlayers() { return this.players; }

	public Board getBoard() { return this.board; }
}
