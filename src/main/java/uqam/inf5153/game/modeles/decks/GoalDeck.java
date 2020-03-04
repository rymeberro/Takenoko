package uqam.inf5153.game.modeles.decks;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Optional;

import uqam.inf5153.game.modeles.goals.Goal;
import uqam.inf5153.game.modeles.goals.PlotGoal;
import uqam.inf5153.game.modeles.goals.configurations.Configuration;
import uqam.inf5153.game.modeles.goals.configurations.CurvedLine;
import uqam.inf5153.game.modeles.goals.configurations.Diamond;
import uqam.inf5153.game.modeles.goals.configurations.StraightLine;
import uqam.inf5153.game.modeles.goals.configurations.Triangle;


public class GoalDeck implements Deck<Goal> {
	
	private LinkedList<Goal> goals;

	//private LinkedList<PlotGoal> pandaGoalDeck ;
	//private LinkedList<PlotGoal> gardnerGoalDeck ;


	public GoalDeck()
	{
		this.goals = new LinkedList<Goal>();
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
		this.goals.add(new PlotGoal(new StraightLine(), 2));
		this.goals.add(new PlotGoal(new StraightLine(), 2));
		this.goals.add(new PlotGoal(new StraightLine(), 2));

		this.goals.add(new PlotGoal(new CurvedLine(), 3));
		this.goals.add(new PlotGoal(new CurvedLine(), 3));
		this.goals.add(new PlotGoal(new CurvedLine(), 3));

		this.goals.add(new PlotGoal(new Triangle(), 4));
		this.goals.add(new PlotGoal(new Triangle(), 4));
		this.goals.add(new PlotGoal(new Triangle(), 4));

		this.goals.add(new PlotGoal(new Diamond(), 5));
		this.goals.add(new PlotGoal(new Diamond(), 5));
		this.goals.add(new PlotGoal(new Diamond(), 5));
	}

	@Override
	public boolean isEmpty() {
		return this.goals.isEmpty();
	}

}
