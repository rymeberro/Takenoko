package uqam.inf5153.game.modeles.goals;

import uqam.inf5153.game.modeles.Board;
import uqam.inf5153.game.modeles.Position;
import uqam.inf5153.game.modeles.Player;
import uqam.inf5153.game.modeles.Plot;
import uqam.inf5153.game.modeles.goals.configurations.Configuration;

import java.util.*;

public class PlotGoal extends Goal {


    private String color;
    private Position position;
    private List<Plot> tileList;
    private Configuration config;
    private int cardPointValue;
    private Board board;

    /*
     * Constructeur d'une carte objectif parcelle
     */
    public PlotGoal (Configuration config, int cardPointValue) {
        this.config = config;
        this.cardPointValue = cardPointValue;
    }

    public PlotGoal() {
        this.cardPointValue = 0;
        this.config = null;
    }

    public Configuration getConfig() {
        return config;
    }

    /*Checks to see if tiles are in the right configuration */
    public boolean isObjectifValid(Board board, Configuration config ) {
        tileList = board.getAllPlot();
        boolean configSatisfied = false;
        boolean sameColors = false;
        boolean allIrrigated = false;
        Configuration.RelativePositions relativePositions = new Configuration.RelativePositions(new Position(0, 0), new Position(0, 0), new Position(0, 0));
        for (int i = 0; i <= tileList.size(); i++) {
            Plot firstPlot = tileList.get(i);
            Position firstPos = firstPlot.getPosition();
            relativePositions =config.getRelativePositions(firstPos);

            Plot secondPlot = board.getPlot(relativePositions.getSecondPos());
            Plot thirdPlot = board.getPlot(relativePositions.getThirdPos());
            Plot forthPlot = board.getPlot(relativePositions.getForthPos());

            allIrrigated = areAllIrrigated(firstPlot, secondPlot, thirdPlot, forthPlot);
            sameColors = isSameColors(firstPlot, secondPlot, thirdPlot, forthPlot, config);
        }
        return configSatisfied && sameColors && allIrrigated;
    }

    public boolean areAllIrrigated (Plot firstPlot, Plot secondPlot, Plot thirdPlot, Plot forthPlot ) {
        if (board.isPlotIrrigated(firstPlot) && board.isPlotIrrigated(secondPlot) &&
                board.isPlotIrrigated(thirdPlot) && board.isPlotIrrigated(forthPlot)) {
            return true;
        }
        else return false;
    }

    public boolean isSameColors (Plot firstPlot, Plot secondPlot, Plot thirdPlot, Plot forthPlot, Configuration config) {

        if (config.getConfigName() == "Diamond") {
            if (firstPlot.getColor().equals(secondPlot.getColor()) && thirdPlot.getColor().equals(forthPlot.getColor())) {
                return true;
            } else return false;
        } else {
            if (firstPlot.getColor().equals(secondPlot.getColor())
                    && secondPlot.getColor().equals(thirdPlot.getColor())) {
                return true;
            } else return false;
        }
    }

    public void applyCard(Player player, Configuration config ) {
        int pointsToAdd = config.getCardPointValue();

        //TO DO: mark card as used/deactivate

        //TO DO: add the points to the player score

        //TO DO: increment number of objective cards used
    }

}
