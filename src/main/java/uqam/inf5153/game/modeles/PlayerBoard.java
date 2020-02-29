package uqam.inf5153.game.modeles;

import java.util.ArrayList;
import java.util.List;

import uqam.inf5153.game.modeles.goals.Goal;

public class PlayerBoard {

	private List<Plot> plots;
	private List<Goal> goals;
	private List<WaterChannel> waterChannels;
	private int countGoalAchieved;

	
	public PlayerBoard()
	{
		this.plots = new ArrayList<Plot>();
		this.goals = new ArrayList<Goal>();
		this.waterChannels = new ArrayList<WaterChannel>();
		this.countGoalAchieved = 0;
	}

	public List<Plot> getPlotList () {
		return plots;
	}

	public ArrayList<Plot> getTiles() {

		ArrayList<Plot> plotList = new ArrayList<Plot>();
		return plotList;
	}

	public Plot getTile(Position position) {

		ArrayList<Plot> plotList = getTiles();
		Plot plot = new Plot();
		for (int i = 0; i <= plotList.size(); i++) {
			if ((plotList.get(i)).getPosition() == position) {
				plot= plotList.get(i);
			}
		}
		return plot;
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

	public WaterChannel popWaterChannel(int i_index)
	{
		return this.waterChannels.get(i_index);
	}

}
