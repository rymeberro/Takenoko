package uqam.inf5153.game.modeles;

import javax.swing.text.html.Option;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
		if(plotList.place(element)) return true;
		else
		{
			element.setPosition(0, 0);
			return false;
		}
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

	public Optional<Plot> getPlot(Position position) {
		ArrayList<Plot> allPlots = plotList.getAll();
		Optional<Plot> plot = Optional.empty();
		for (int i = 0; i < allPlots.size() ; i++) {
			if ((allPlots.get(i)).getPosition() == position) {
				plot = Optional.of(allPlots.get(i));
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

	@Override
	public String toString()
	{
		String str = "";
		List<Plot> plots = this.plotList.getAll();
		str += "Parcelles:\n";
		for(int i = 0; i < plots.size(); i++)
		{
			str += i + " - \t " + plots.get(i).toString() + "\n";
		}

		List<WaterChannel> wtc = this.waterChannelList.getAll();
		str += "Irrigations:\n";
		for(int i = 0; i < wtc.size(); i++)
		{
			str += i + " - \t " + wtc.get(i).toString() + "\n";
		}
		str += "Le Jardinier est en " + this.gardener.getPosition() + "\n";
		return str;
	}


}
