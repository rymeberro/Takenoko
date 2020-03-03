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

	private LinkedList<PlotGoal> plotGoalDeck ;
    private PlotGoal plotGoal ;
    private Configuration config;
	//private LinkedList<PlotGoal> pandaGoalDeck ;
	//private LinkedList<PlotGoal> gardnerGoalDeck ;


	public GoalDeck()
	{
		this.goals = new LinkedList<Goal>();
		this.plotGoalDeck= new LinkedList<PlotGoal>();

        this.plotGoal = new PlotGoal() ;

        this.goals.add(this.plotGoal = new PlotGoal(new StraightLine(), 2));
        this.goals.add(this.plotGoal = new PlotGoal(new StraightLine(), 2));
        this.goals.add(this.plotGoal = new PlotGoal(new StraightLine(), 2));

        this.goals.add(this.plotGoal = new PlotGoal(new CurvedLine(), 3));
        this.goals.add(this.plotGoal = new PlotGoal(new CurvedLine(), 3));
        this.goals.add(this.plotGoal = new PlotGoal(new CurvedLine(), 3));

        this.goals.add(this.plotGoal = new PlotGoal(new Triangle(), 4));
        this.goals.add(this.plotGoal = new PlotGoal(new Triangle(), 4));
        this.goals.add(this.plotGoal = new PlotGoal(new Triangle(), 4));

        this.goals.add(this.plotGoal = new PlotGoal(new Diamond(), 5));
        this.goals.add(this.plotGoal = new PlotGoal(new Diamond(), 5));
        this.goals.add(this.plotGoal = new PlotGoal(new Diamond(), 5));
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
