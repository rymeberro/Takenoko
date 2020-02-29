package uqam.inf5153.game.modeles;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;


public class Board {

	private PieceList pieceList;
	private PlotList plotList;
	private WaterChannelList waterChannelList;

	public Board() {
		this.pieceList = new PieceList();
		this.plotList = new PlotList();
		this.waterChannelList = new WaterChannelList();

	}

	public boolean placePlot(Plot element, double x, double y) {
		element.setPosition(x,y);
		return plotList.place(element);
	}

	public boolean placeWaterChannel(double x, double y) {
		WaterChannel waterChannel = new WaterChannel(createPosition(x, y));
		return waterChannelList.place(waterChannel);
	}

	public ArrayList<Position> getAllPlotPos() {
		return plotList.getAllPos();
	}

	public ArrayList<Plot> getAllPlot(){
		return plotList.getAll();
	}

	private Position createPosition(double x, double y) {
		Position position = new Position(x, y);
		return position;
	}


}
