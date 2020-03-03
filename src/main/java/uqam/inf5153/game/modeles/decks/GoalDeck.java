package uqam.inf5153.game.modeles.decks;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Optional;

import uqam.inf5153.game.modeles.goals.Goal;
import uqam.inf5153.game.modeles.goals.PlotGoal;


public class GoalDeck implements Deck<Goal> {
	
	private LinkedList<Goal> goals;

	private LinkedList<PlotGoal> plotGoalDeck ;
	//private LinkedList<PlotGoal> pandaGoalDeck ;
	//private LinkedList<PlotGoal> gardnerGoalDeck ;


	public GoalDeck()
	{
		this.goals = new LinkedList<Goal>();
		this.plotGoalDeck= new LinkedList<PlotGoal>();
	}

	@Override
	public Optional<Goal> pick() {
		try
		{
			return Optional.of(this.goals.poll());
		} catch (NoSuchElementException e)
		{
			return Optional.empty();
		}
	}

	@Override
	public void init() {
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 15; j++)
			{

			}
		}
	}

	@Override
	public boolean isEmpty() {
		return this.goals.isEmpty();
	}

}
