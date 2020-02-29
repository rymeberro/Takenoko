package main.java.uqam.inf5153.game.modeles;

import java.util.ArrayList;
import java.util.List;

import main.java.uqam.inf5153.game.modeles.goals.Goal;
import main.java.uqam.inf5153.game.modeles.plots.Plot;
import main.java.uqam.inf5153.game.modeles.PlayerBoard;
import main.java.uqam.inf5153.game.modeles.decks.PlotDeck;

public class Player
{
    private int id;
    private String name;
    private List<Plot> standbyListOfPlots; // list of plots that player picked

    public Player()
    {
        this.id = 0;
        this.name = "";
        this.standbyListOfPlots = new ArrayList<Plot>();
    }

    public Player(int i_id, String i_name)
    {
        this.id = id;
        this.name = i_name;
        this.standbyListOfPlots = new ArrayList<Plot>();
    }

    // When player takes 3 plots, they are added in the player's standby list of plots
    public addToStandByList(List<Plot> i_plots)
    {
        for(Plot plot : i_plots)
        {
            this.standbyListOfPlots.add(plot);
        }
    }

    // Adds chosen plot to PlayerBoard
    public void addPlotToPlayerBoardPlots(PlayerBoard i_playerBoard, Plot i_plot)
    {
        i_playerBoard.addPlot(i_plot);
    }

    // Adds the remaining 2 plots in standbyListOfPlots to the bottom of PlotDeck
    public void movePlotsToBottomOfPlotDeck(PlotDeck i_plotDeck)
    {
        for(Plot plot : standbyListOfPlots)
        {
            i_plotDeck.addPlot(plot);
        }
    }

    // Removes the remaining 2 plots in standbyListOfPlots
    public void emptyStandByListOfPlots()
    {
        this.standbyListOfPlots.clear();
    }

    // Removes the chosen plot from standbyListOfPlots
    public void removePlot(Plot i_plot)
    {
        this.standbyListOfPlots.remove(i_plot);
    }
}
