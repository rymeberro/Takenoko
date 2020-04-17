package uqam.inf5153.game.modeles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import uqam.inf5153.game.modeles.goals.Goal;
import uqam.inf5153.game.modeles.goals.PlotGoal;

public class PlayerBoard {

	private LinkedList<Plot> plots;
	private LinkedList<Goal> goals;
	private LinkedList<PlotGoal> plotGoalCards;
	private LinkedList<WaterChannel> waterChannels;
	private int countGoalAchieved;


	public PlayerBoard()
	{
		this.plots = new LinkedList<Plot>();
		this.goals = new LinkedList<Goal>();
		this.plotGoalCards = new LinkedList<PlotGoal>();
		this.waterChannels = new LinkedList<WaterChannel>();
		this.countGoalAchieved = 0;
	}


	public int getCountGoalAchieved() { return this.getCountGoalAchieved(); }

	public void addPlot(Plot i_plot)
	{
		this.plots.add(i_plot);
	}

	public void addGoal(Goal i_goal)
	{
		this.goals.add(i_goal);
	}

	public void addWaterChannel(WaterChannel i_irrigation)
	{
		this.waterChannels.add(i_irrigation);
	}

	public WaterChannel popWaterChannel() {	return this.waterChannels.poll(); }

	public boolean hasWaterChannel() { return !this.waterChannels.isEmpty(); }

	public List<Goal> getGoals() { return this.goals; }

}
