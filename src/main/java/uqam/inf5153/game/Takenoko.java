package uqam.inf5153.game;

import uqam.inf5153.game.modeles.Player;
import uqam.inf5153.game.modeles.Plot;
import uqam.inf5153.game.modeles.Position;
import uqam.inf5153.game.modeles.WaterChannel;
import uqam.inf5153.game.modeles.goals.Goal;
import uqam.inf5153.game.modeles.goals.PlotGoal;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Crée par Imen Benzarti le 13/01/2020
 * une classe controlleur du jeu (voir le parton GRASP controlleur)
 * Elle n'implémente aucune des méthodes : elle oriente les actions envoyées par les joueurs 
 * vers les classes responsable de les implémenter.
 */
public class Takenoko {


	public static Game GAME = null;

	static
	{
		Takenoko.GAME = new Game();
	}

	/**
	 * les parcelles
	 */

	/*
	 * Piocher i parcelle de la pioche du joueur joueur
	 */
	public static List<Plot> piocherParcelles(int i, int joueur) {
		List<Plot> plots = new ArrayList<Plot>();
		for(int j = 0; j < i; j++)
		{
			Optional<Plot> plot = GAME.pickPlot();
			if(!plot.isPresent()) break;
			plots.add(plot.get());
		}
		return plots;
	}
	/*
	 * selectionne uneParcelle parmi les parcelles piochés et retourne les autres à la pioche.
	 */
	public static void selectionnerParcelle(Plot parcelle, int joueur) {
		GAME.getPlayers().get(joueur - 1).getBoard().addPlot(parcelle);
	}
	/*
	 * afficher un ensemble de parcelles
	 */
	public static void afficherParcelles(List<Plot> parcelles) {
		for(int i = 0; i < parcelles.size(); i++) System.out.println(i + " - \t " + parcelles.get(i).toString());
	}

	/*
	 * afficher les parcelles déposé
	 */
	public static void afficherParcellesPlateau() {
		System.out.println(GAME.getBoard());
	}

	/*
	 * placer une parcelle dans la position (x,y) dans le plateau.
	 * retourne true si la parcelle est bien placée, sinon elle retourne false.
	 */
	public static boolean placerParcelleDansPlateau(Plot parcelle, double x, double y) {
		return GAME.getBoard().placePlot(parcelle, x, y);
	}
	/**
	 * piocher une irrigation du joueur 
	 */

	/*
	 * piocher une irrigation dans la pioche des irrigation du joueur
	 *
	 */
	public static boolean piocherUneIrrigation(int joueur) {
		Optional<WaterChannel> waterChannel = GAME.pickWaterChannel();
		if(!waterChannel.isPresent()) return false;
		GAME.getPlayers().get(joueur - 1).getBoard().addWaterChannel(waterChannel.get());
		return true;
	}
	/*
	 * placer une irrigation entre les parcelles (x1,y1) et (x2, y2).
	 * retourne true si l'irrigation est bien placée
	 */
	public static boolean placerUneIrrigation( double x1, double y1, double x2, double y2) {
		Optional<Plot> p1 = Optional.empty();
		Optional<Plot> p2 = Optional.empty();
		List<Plot> plots = GAME.getBoard().getAllPlot();
		for(Plot p : plots)
		{
			if(p.getPosition().equals(new Position(x1, y1))) p1 = Optional.of(p);
			else if(p.getPosition().equals(new Position(x2, y2))) p2 = Optional.of(p);
		}
		if(!p1.isPresent() || !p2.isPresent()) return false;
		return GAME.getBoard().placeWaterChannel(p1.get(), p2.get());
	}
	/**
	 * objectifs
	 */

	/*
	 * retourne tous les objectis piochées par le joueur
	 */
	public static List<Goal> afficherObjectifsJoueur(int joueur) {
		return GAME.getPlayers().get(joueur - 1).getBoard().getGoals();
	}

	/*
	 * selectionner un objectif un remplir parmi un ensemble d'objectif piochés
	 * retourne l'objectif selectionné
	 */
	public static Optional<Goal> selectionnerObjectifARemplir(List<Goal> objectifs) {
		if(objectifs.size() == 0)
		{
			System.out.println("Vous n'avez aucun objectif !");
			return Optional.empty();
		}
		System.out.println("Voici la liste de vos objectifs: ");
		for(int i = 0; i < objectifs.size(); i++)
		{
			System.out.println(i + " - \t " + objectifs.get(i).description());
		}
		int index = Keyin.inInt(" Entrer l'objectif à remplir : ");
		while(index < 0 || index > objectifs.size() - 1) index = Keyin.inInt(" Entrer l'objectif à remplir : ");
		return Optional.of(objectifs.get(index));
	}

	/*
	 * le joueur rempli un objectif
	 * retourne true si l'objectif est rempli, sinon elle retourne false.
	 */
	public static boolean remplirObjectif(int joueur, Goal objectif) {
		if(objectif.isCompleted(GAME.getBoard()))
		{
			GAME.getPlayers().get(joueur - 1).addScore(objectif.getScore());
			GAME.getPlayers().get(joueur - 1).getBoard().getGoals().remove(objectif);
			return true;
		} else return false;
	}

	/*
	 * piocher un objectif dans la pioche du joueur
	 */
	public static Optional<Goal> piocherObjectif() {
		return GAME.pickGoal();
	}

	/**
	 * jardinier
	 */

	/*
	 * placer le jardinier dans la position (x,y).
	 * retourne true si le jardinier est déplacé, sinon elle retourne false
	 */
	public static boolean PlacerJardinier(double x, double y) {
		return GAME.getBoard().moveGardenerTo(x, y);
	}



	/**
	 * panda
	 */

	/*
	 * placer le panda du joueur dans la parcelle dans la position (x,y)  de son plateau.
	 * retourne true si le panda est déplacé, sinon elle retourne false
	 */
	public static boolean PlacerPanda(double x, double y, int joueur) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * fin DE partie
	 */

	/*
	 * retourne true si la partie est terminé.
	 * Pour deux joueur une partie prend fin si un des joueur remplit son 9ème objectif
	 */
	public static boolean finPartie() {
		return GAME.getRoundManager().isLastRound();
	}
	/**
	 *  Le gagnant
	 */

	/*
	 * annonce la gagnant à la fin de la partie.
	 * et ce en calclant le total des points des objectifs remplis.
	 */
	public static int annoncerGagnant() {
		int index = 0;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < GAME.getPlayers().size(); i++)
		{
			if(GAME.getPlayers().get(i).getScore() > max) index = i;
		}
		Player gagnant = GAME.getPlayers().get(index);
		System.out.println("Le gagnant est le joueur " + (gagnant.getId() + 1) + " appellé " + gagnant.getName() + " !");
		return index;
	}



}
