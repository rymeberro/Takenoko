import org.junit.Before;
import org.junit.Test;
import uqam.inf5153.game.modeles.Board;
import uqam.inf5153.game.modeles.Plot;
import uqam.inf5153.game.modeles.Position;
import uqam.inf5153.game.modeles.WaterChannel;

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
}
