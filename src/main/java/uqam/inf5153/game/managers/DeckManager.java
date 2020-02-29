package uqam.inf5153.game.managers;

import java.util.Optional;

import uqam.inf5153.game.modeles.decks.Deck;

public class DeckManager {

	/**
	 * Pioche une carte dans la pioche donné en paramètre
	 * @param deck Pioche
	 * @param <E> Type de carte de la pioche
	 * @return Une carte de la pioche de type E
	 */
	public <E> Optional<E> pick(Deck<E> deck)
	{
		if(deck.isEmpty()) return Optional.empty();
		return deck.pick();
	}
}
