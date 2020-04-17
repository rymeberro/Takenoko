import org.junit.Before;
import org.junit.Test;
import uqam.inf5153.game.modeles.Board;
import uqam.inf5153.game.modeles.Plot;
import uqam.inf5153.game.modeles.Position;
import uqam.inf5153.game.modeles.WaterChannel;
import uqam.inf5153.game.modeles.amenagements.Bassin;
import uqam.inf5153.game.modeles.goals.PlotGoal;
import uqam.inf5153.game.modeles.goals.configurations.CurvedLine;
import uqam.inf5153.game.modeles.goals.configurations.Diamond;
import uqam.inf5153.game.modeles.goals.configurations.StraightLine;
import uqam.inf5153.game.modeles.goals.configurations.Triangle;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

public class TestBoard {
    Board board;

    @Before
    public void setup(){
        this.board = new Board();
    }


    @Test
    public void test_PlacePlot(){
        Plot plot = new Plot(new Position(0,0),"red");
        board.placePlot(plot,1,2);
        Plot plot2 = new Plot(new Position(0,0),"red");
        board.placePlot(plot2,1,2);
        ArrayList list = this.board.getAllPlot();
        assertTrue(list.size()==2);
        assertTrue(list.get(1).equals(plot));
        assertFalse(board.placePlot(plot2,2,2));
        assertFalse(board.placePlot(plot2,0,0));
        assertFalse(board.placePlot(plot2,4,1));
    }

    @Test
    public void test_PlaceWaterChannel(){
        Plot plot = new Plot(new Position(0,0),"red");
        board.placePlot(plot,1,2);
        Plot plot2 = new Plot(new Position(0,0),"red");
        board.placePlot(plot2,2,0);
        assertTrue(board.placeWaterChannel(plot,plot2));
        ArrayList list = this.board.getAllWaterChannel();
        assertTrue(list.size()==7);
    }

    @Test
    public void test_isPlotIrrigated(){
        Plot plot = new Plot(new Position(0,0),"red");
        board.placePlot(plot,1,2);
        Plot plot2 = new Plot(new Position(0,0),"red");
        board.placePlot(plot2,2,0);
        Plot plot3 = new Plot(new Position(0,0),"red");
        board.placePlot(plot3,3,2);
        assertFalse(board.isPlotIrrigated(plot3));
        assertTrue(board.isPlotIrrigated(plot2));
        assertTrue(board.isPlotIrrigated(plot));
    }

    @Test
    public void test_moveGardenerTo(){
        Plot plot = new Plot(new Position(0,0),"red");
        board.placePlot(plot,-1,2);
        assertFalse(board.moveGardenerTo(2,4));
        assertTrue(board.moveGardenerTo(-1,2));
        assertTrue(board.getGardener().getPosition().equals(new Position(-1,2)));
    }

    @Test
    public void test_movePandaTo(){
        Plot plot = new Plot(new Position(0,0),"red");
        board.placePlot(plot,-1,2);
        assertFalse(board.movePandaTo(2,4));
        assertTrue(board.movePandaTo(-1,2));
        assertTrue(board.getPanda().getPosition().equals(new Position(-1,2)));
    }

    @Test
    public void test_CurvedLineConfig(){
        Plot plot = new Plot(new Position(0,0),"red");
        board.placePlot(plot,1,2);
        Plot plot2 = new Plot(new Position(0,0),"red");
        board.placePlot(plot2,2,0);
        Plot plot3 = new Plot(new Position(0,0),"red");
        plot3.setAmenagement(new Bassin());
        board.placePlot(plot3,1,-2);
        PlotGoal plotGoal = new PlotGoal(new CurvedLine(), 0);
        assertTrue(plotGoal.isObjectifValid(board, new CurvedLine()));
        assertFalse(plotGoal.isObjectifValid(board, new Diamond()));
        assertFalse(plotGoal.isObjectifValid(board, new StraightLine()));
        assertFalse(plotGoal.isObjectifValid(board, new Triangle()));
    }

    @Test
    public void test_StraightLineConfig(){
        Plot plot = new Plot(new Position(0,0),"red");
        board.placePlot(plot,1,2);
        Plot plot2 = new Plot(new Position(0,0),"red");
        board.placePlot(plot2,2,0);
        Plot plot4 = new Plot(new Position(0,0),"red");
        board.placePlot(plot4,1,-2); // Pour pouvoir placer plot3
        Plot plot3 = new Plot(new Position(0,0),"red");
        board.placePlot(plot3,3,-2);
        plot.setAmenagement(new Bassin());
        plot3.setAmenagement(new Bassin());
        PlotGoal plotGoal = new PlotGoal(new StraightLine(), 0);
        assertTrue(plotGoal.isObjectifValid(board, new StraightLine()));
        assertFalse(plotGoal.isObjectifValid(board, new Diamond()));
        assertFalse(plotGoal.isObjectifValid(board, new CurvedLine()));
        assertFalse(plotGoal.isObjectifValid(board, new Triangle()));
    }

    @Test
    public void test_TriangleConfig(){
        Plot plot = new Plot(new Position(0,0),"red");
        board.placePlot(plot,1,-2);
        Plot plot2 = new Plot(new Position(0,0),"red");
        board.placePlot(plot2,2,0);
        Plot plot3 = new Plot(new Position(0,0),"red");
        board.placePlot(plot3,3,-2);
        plot.setAmenagement(new Bassin());
        plot3.setAmenagement(new Bassin());
        PlotGoal plotGoal = new PlotGoal(new Triangle(), 0);
        assertTrue(plotGoal.isObjectifValid(board, new Triangle()));
        assertFalse(plotGoal.isObjectifValid(board, new Diamond()));
        assertFalse(plotGoal.isObjectifValid(board, new CurvedLine()));
        assertFalse(plotGoal.isObjectifValid(board, new StraightLine()));
    }

    @Test
    public void test_DiamondConfig(){
        Plot plot = new Plot(new Position(0,0),"red");
        board.placePlot(plot,1,2);
        Plot plot2 = new Plot(new Position(0,0),"red");
        board.placePlot(plot2,2,0);
        Plot plot3 = new Plot(new Position(0,0),"red");
        board.placePlot(plot3,3,2);
        Plot plot4 = new Plot(new Position(0,0),"red");
        board.placePlot(plot4,4,0);
        plot.setAmenagement(new Bassin());
        plot3.setAmenagement(new Bassin());
        plot4.setAmenagement(new Bassin());
        PlotGoal plotGoal = new PlotGoal(new Diamond(), 0);
        assertTrue(plotGoal.isObjectifValid(board, new Diamond()));
        assertTrue(plotGoal.isObjectifValid(board, new Triangle()));
        assertFalse(plotGoal.isObjectifValid(board, new CurvedLine()));
        assertFalse(plotGoal.isObjectifValid(board, new StraightLine()));
    }

}
