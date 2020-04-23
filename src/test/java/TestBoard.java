import org.junit.Before;
import org.junit.Test;
import uqam.inf5153.game.modeles.Board;
import uqam.inf5153.game.modeles.Plot;
import uqam.inf5153.game.modeles.Position;
import uqam.inf5153.game.modeles.WaterChannel;
import uqam.inf5153.game.modeles.amenagements.Bassin;
import uqam.inf5153.game.modeles.amenagements.Enclos;
import uqam.inf5153.game.modeles.amenagements.Engrais;
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
        assertTrue(board.placePlot(plot,1,2));
        Plot plot2 = new Plot(new Position(0,0),"red");
        assertTrue(board.placePlot(plot2,2,0));
        ArrayList list = this.board.getAllPlot();
        assertTrue(list.size()==3); // Il faut aussi compter l'étang (1 + 2 = 3).
        assertTrue(list.get(1).equals(plot));
        assertFalse(board.placePlot(plot2,2,2));
        assertFalse(board.placePlot(plot2,0,0));
        assertFalse(board.placePlot(plot2,4,1));
    }

    @Test
    public void test_PlaceWaterChannel(){
        Plot plot = new Plot(new Position(0,0),"red");
        assertTrue(board.placePlot(plot,1,2));
        Plot plot2 = new Plot(new Position(0,0),"red");
        assertTrue(board.placePlot(plot2,2,0));
        assertTrue(board.placeWaterChannel(plot,plot2));
        ArrayList list = this.board.getAllWaterChannel();
        assertTrue(list.size()==7);
    }

    @Test
    public void test_isPlotIrrigated(){
        Plot plot = new Plot(new Position(0,0),"red");
        assertTrue(board.placePlot(plot,1,2));
        Plot plot2 = new Plot(new Position(0,0),"red");
        assertTrue(board.placePlot(plot2,2,0));
        Plot plot3 = new Plot(new Position(0,0),"red");
        assertTrue(board.placePlot(plot3,3,2));
        assertFalse(board.isPlotIrrigated(plot3));
        assertTrue(board.isPlotIrrigated(plot2));
        assertTrue(board.isPlotIrrigated(plot));
    }

    @Test
    public void test_moveGardenerTo(){
        Plot plot = new Plot(new Position(0,0),"red");
        assertTrue(board.placePlot(plot,-1,2));
        assertFalse(board.moveGardenerTo(2,4));
        assertTrue(board.moveGardenerTo(-1,2));
        assertTrue(board.getGardener().getPosition().equals(new Position(-1,2)));
    }

    @Test
    public void test_movePandaTo(){
        Plot plot = new Plot(new Position(0,0),"red");
        assertTrue(board.placePlot(plot,-1,2));
        assertFalse(board.movePandaTo(2,4));
        assertTrue(board.movePandaTo(-1,2));
        assertTrue(board.getPanda().getPosition().equals(new Position(-1,2)));
    }

    @Test
    public void test_CurvedLineConfig(){
        Plot plot = new Plot(new Position(0,0),"red");
        assertTrue(board.placePlot(plot,1,2));
        Plot plot2 = new Plot(new Position(0,0),"red");
        assertTrue(board.placePlot(plot2,2,0));
        Plot plot3 = new Bassin(new Position(0,0),"red"); // Utilisation d'un bassin pour qu'il soit irrigué de base.
        assertTrue(board.placePlot(plot3,1,-2));
        PlotGoal plotGoal = new PlotGoal(new CurvedLine(), 0);
        assertTrue(plotGoal.isObjectifValid(board, new CurvedLine()));
        assertFalse(plotGoal.isObjectifValid(board, new Diamond()));
        assertFalse(plotGoal.isObjectifValid(board, new StraightLine()));
        assertFalse(plotGoal.isObjectifValid(board, new Triangle()));
    }

    @Test
    public void test_StraightLineConfig(){
        Plot plot = new Bassin(new Position(0,0),"red"); // Utilisation d'un bassin pour qu'il soit irrigué de base.
        assertTrue(board.placePlot(plot,1,2));
        Plot plot2 = new Plot(new Position(0,0),"red");
        assertTrue(board.placePlot(plot2,2,0));
        Plot plot4 = new Plot(new Position(0,0),"red");
        assertTrue(board.placePlot(plot4,1,-2)); // Pour pouvoir placer plot3.
        Plot plot3 = new Bassin(new Position(0,0),"red"); // Utilisation d'un bassin pour qu'il soit irrigué de base.
        assertTrue(board.placePlot(plot3,3,-2));
        PlotGoal plotGoal = new PlotGoal(new StraightLine(), 0);
        assertTrue(plotGoal.isObjectifValid(board, new StraightLine()));
        assertFalse(plotGoal.isObjectifValid(board, new Diamond()));
        assertFalse(plotGoal.isObjectifValid(board, new CurvedLine()));
        assertFalse(plotGoal.isObjectifValid(board, new Triangle()));
    }

    @Test
    public void test_TriangleConfig(){
        Plot plot = new Bassin(new Position(0,0),"red"); // Utilisation d'un bassin pour qu'il soit irrigué de base.
        assertTrue(board.placePlot(plot,1,-2));
        Plot plot2 = new Plot(new Position(0,0),"red");
        assertTrue(board.placePlot(plot2,2,0));
        Plot plot3 = new Bassin(new Position(0,0),"red"); // Utilisation d'un bassin pour qu'il soit irrigué de base.
        assertTrue(board.placePlot(plot3,3,-2));
        PlotGoal plotGoal = new PlotGoal(new Triangle(), 0);
        assertTrue(plotGoal.isObjectifValid(board, new Triangle()));
        assertFalse(plotGoal.isObjectifValid(board, new Diamond()));
        assertFalse(plotGoal.isObjectifValid(board, new CurvedLine()));
        assertFalse(plotGoal.isObjectifValid(board, new StraightLine()));
    }

    @Test
    public void test_DiamondConfig(){
        Plot plot = new Bassin(new Position(0,0),"red"); // Utilisation d'un bassin pour qu'il soit irrigué de base.
        assertTrue(board.placePlot(plot,1,2));
        Plot plot2 = new Plot(new Position(0,0),"red");
        assertTrue(board.placePlot(plot2,2,0));
        Plot plot3 = new Bassin(new Position(0,0),"red"); // Utilisation d'un bassin pour qu'il soit irrigué de base.
        assertTrue(board.placePlot(plot3,3,2));
        Plot plot4 = new Bassin(new Position(0,0),"red"); // Utilisation d'un bassin pour qu'il soit irrigué de base.
        assertTrue(board.placePlot(plot4,4,0));
        PlotGoal plotGoal = new PlotGoal(new Diamond(), 0);
        assertTrue(plotGoal.isObjectifValid(board, new Diamond()));
        assertTrue(plotGoal.isObjectifValid(board, new Triangle()));
        assertFalse(plotGoal.isObjectifValid(board, new CurvedLine()));
        assertFalse(plotGoal.isObjectifValid(board, new StraightLine()));
    }

    @Test
    public void test_EnclosJardinierPanda(){
        Plot enclos = new Enclos(new Position(0,0),"red");
        assertTrue(board.placePlot(enclos,2, 0));
        assertTrue(board.moveGardenerTo(2, 0));
        assertEquals(1, enclos.countBamboo());
        assertTrue(board.movePandaTo(2, 0));
        assertEquals(1, enclos.countBamboo());
    }

    @Test
    public void test_EngraisJardinierPanda(){
        Plot engrais = new Engrais(new Position(0,0),"red");
        assertTrue(board.placePlot(engrais,2, 0));
        assertTrue(board.moveGardenerTo(2, 0));
        assertEquals(2, engrais.countBamboo());
        assertTrue(board.movePandaTo(2, 0));
        assertEquals(1, engrais.countBamboo());
    }

    @Test
    public void test_EngraisNonIrriguePandaEtPropagation(){
        Plot plot = new Plot(new Position(0,0),"red");
        assertTrue(board.placePlot(plot,2, 0));
        Plot plot2 = new Plot(new Position(0,0),"red");
        assertTrue(board.placePlot(plot2,1, 2));
        Plot engrais = new Engrais(new Position(0,0),"red");
        assertTrue(board.placePlot(engrais,3, 2));
        assertFalse(board.isPlotIrrigated(engrais));
        assertTrue(board.moveGardenerTo(3, 2));
        assertEquals(0, engrais.countBamboo());
        assertEquals(1, plot.countBamboo());
        assertEquals(1, plot2.countBamboo());
        assertTrue(board.movePandaTo(3, 2));
        assertEquals(0, engrais.countBamboo());
    }


    @Test
    public void test_BassinIrrigueJardinierPanda(){
        Plot plot = new Plot(new Position(0,0),"red");
        assertTrue(board.placePlot(plot,2, 0));
        Plot plot2 = new Plot(new Position(0,0),"red");
        assertTrue(board.placePlot(plot2,1, 2));
        Plot bassin = new Bassin(new Position(0,0),"red");
        assertTrue(board.placePlot(bassin,3, 2));
        assertTrue(board.isPlotIrrigated(bassin));
        assertTrue(board.moveGardenerTo(3, 2));
        assertEquals(2, bassin.countBamboo()); // Il y en a 1 de base (effet bassin) + 1 à l'arrivée du jardinier sur la pacerelle.
        assertTrue(board.movePandaTo(3, 2));
        assertEquals(1, bassin.countBamboo());
    }

}
