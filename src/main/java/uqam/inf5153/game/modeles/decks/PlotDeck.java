package uqam.inf5153.game.modeles.decks;

import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Optional;

import uqam.inf5153.game.modeles.Plot;
import uqam.inf5153.game.modeles.Position;
import uqam.inf5153.game.modeles.amenagements.Bassin;
import uqam.inf5153.game.modeles.amenagements.Enclos;
import uqam.inf5153.game.modeles.amenagements.Engrais;

public class PlotDeck implements Deck<Plot> {

	private static final String[] COLORS = {"YELLOW", "PINK", "GREEN"};

	private LinkedList<Plot> plots;
	
	public PlotDeck()
	{
		this.plots = new LinkedList<Plot>();
	}
	
	
	@Override
	public Optional<Plot> pick() {
		try
		{
			return Optional.of(this.plots.poll());
		} catch (NoSuchElementException e)
		{
			return Optional.empty();
		}
	}

	@Override
	public void init() {
		for(int color_i = 0; color_i < 3; color_i++)
		{
			for(int j = 0; j < 6; j++) // Reduction de 9 à 6 pour pouvoir placer 3 aménagements par couleur
			{
				this.plots.add(new Plot(new Position(0, 0), PlotDeck.COLORS[color_i]));
			}
			this.plots.add(new Bassin(new Position(0, 0), PlotDeck.COLORS[color_i]));
			this.plots.add(new Enclos(new Position(0, 0), PlotDeck.COLORS[color_i]));
			this.plots.add(new Engrais(new Position(0, 0), PlotDeck.COLORS[color_i]));
		}
		Collections.shuffle(this.plots);
	}
	
	@Override
	public boolean isEmpty() {
		return this.plots.isEmpty();
	}

}
