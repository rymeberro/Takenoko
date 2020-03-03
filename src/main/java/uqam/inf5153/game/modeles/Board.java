package uqam.inf5153.game.modeles;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;


public class Board {

	private PieceList pieceList;
	private PlotList plotList;
	private WaterChannelList waterChannelList;
	private Gardener gardener;

	public Board() {
		this.pieceList = new PieceList();
		this.plotList = new PlotList();
		this.waterChannelList = new WaterChannelList();
		this.gardener = new Gardener(0,0);
	}

	public boolean placePlot(Plot element, double x, double y) {
		element.setPosition(x,y);
		return plotList.place(element);
	}

	public boolean placeWaterChannel(Plot element1, Plot element2) {
		return waterChannelList.place(element1, element2, getAllPlot() );
	}

	public ArrayList<Position> getAllPlotPos() {
		return plotList.getAllPos();
	}

	public ArrayList<Plot> getAllPlot(){
		return plotList.getAll();
	}

	public ArrayList<WaterChannel> getAllWaterChannel(){
		return waterChannelList.getAll();
	}

	public Plot getPlot(Position position) {
		ArrayList<Plot> allPlots = plotList.getAll();
		Plot plot = null;
		for (int i = 0; i <= allPlots.size() ; i++) {
			if ((allPlots.get(i)).getPosition() == position) {
				plot= allPlots.get(i);
			}
		}

		return plot;
	}

	public boolean isPlotIrrigated(Plot element){
		ArrayList<WaterChannel> wtc = getAllWaterChannel();
		return this.plotList.isPlotIrrigated(element,wtc);
	}

	public boolean moveGardenerTo(double x, double y){
		return this.gardener.moveTo(x,y,getAllPlot());
	}


}
