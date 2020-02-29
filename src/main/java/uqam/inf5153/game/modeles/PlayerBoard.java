package main.java.uqam.inf5153.game.modeles;

import java.util.ArrayList;
import java.util.List;

import main.java.uqam.inf5153.game.modeles.goals.Goal;
import main.java.uqam.inf5153.game.modeles.plots.Plot;
import main.java.uqam.inf5153.game.modeles.WaterChannel;

public class PlayerBoard
{
	private List<Plot> plots; // Plots in player's possession
	private List<Goal> goals; // Goals in player's possession
	private List<WaterChannel> waterChannels; // Irrigations available to player
	
	public PlayerBoard()
	{
		this.plots = new ArrayList<Plot>();
		this.goals = new ArrayList<Goal>();
		this.waterChannels = new ArrayList<WaterChannel>();
	}

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

	public WaterChannel popWaterChannel(int i_index)
	{
		return this.waterChannels.get(i_index);
	}
}
