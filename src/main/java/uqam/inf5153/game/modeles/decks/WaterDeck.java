package uqam.inf5153.game.modeles.decks;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Optional;

import uqam.inf5153.game.modeles.WaterChannel;

public class WaterDeck implements Deck<WaterChannel> {

	private LinkedList<WaterChannel> waterChannels;
	
	public WaterDeck()
	{
		this.waterChannels = new LinkedList<WaterChannel>();
	}
	
	@Override
	public Optional<WaterChannel> pick() {
		try
		{
			return Optional.of(this.waterChannels.poll());
		} catch (NoSuchElementException e)
		{
			return Optional.empty();
		}
	}

	@Override
	public void init() {
		for(int i = 0; i < 20; i++)
		{
			this.waterChannels.add(new WaterChannel());
		}
	}
	
	@Override
	public boolean isEmpty() {
		return this.waterChannels.isEmpty();
	}

}
