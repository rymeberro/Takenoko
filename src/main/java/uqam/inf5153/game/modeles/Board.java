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
	private Panda panda;

	public Board() {
		this.pieceList = new PieceList();
		this.plotList = new PlotList();
		this.waterChannelList = new WaterChannelList();
		this.gardener = new Gardener(0,0);
		this.panda = new Panda(0,0);
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
			if ((allPlots.get(i)).getPosition().equals(position)) {
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
		Position position = new Position(x,y);
		if(this.gardener.moveTo(x,y,getAllPlot())){
			Plot targetPlot = getPlot(position).get();
			ArrayList<Plot> list = getPlotAround(x,y);
			if(isPlotIrrigated(targetPlot)){
				addBamboo(targetPlot);
			}
			for(Plot i: list){
				if(isPlotIrrigated(i) && i.getColor()==targetPlot.getColor()){
					addBamboo(i);
				}
			}
			return true;
		}else{
			return false;
		}
	}

	public boolean movePandaTo(double x, double y){
		Position position = new Position(x,y);
		if(this.panda.moveTo(x,y,getAllPlot())){
			Plot targetPlot = getPlot(position).get();
			return removeBamboo(targetPlot);
		};
		return false;
	}

	private boolean removeBamboo(Plot plot){
		return plotList.addBamboo(plot);
	}

	private boolean addBamboo(Plot plot){
		return plotList.removeBamboo(plot);
	}

	private ArrayList<Plot> getPlotAround(double x, double y){
		ArrayList<Plot> list = new ArrayList<Plot>();
		Position position1 = new Position(x-1,y+2);
		if(getPlot(position1).isPresent()){
			list.add(getPlot(position1).get());
		}
		Position position2 = new Position(x-2,y);
		if(getPlot(position2).isPresent()){
			list.add(getPlot(position2).get());
		}
		Position position3 = new Position(x-1,y-2);
		if(getPlot(position3).isPresent()){
			list.add(getPlot(position3).get());
		}
		Position position4 = new Position(x+1,y+2);
		if(getPlot(position4).isPresent()){
			list.add(getPlot(position4).get());
		}
		Position position5 = new Position(x+2,y);
		if(getPlot(position5).isPresent()){
			list.add(getPlot(position5).get());
		}
		Position position6 = new Position(x+1,y-2);
		if(getPlot(position6).isPresent()){
			list.add(getPlot(position6).get());
		}
		return list;
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
		str += "Le Panda est en " + this.panda.getPosition() + "\n";
		return str;
	}

	public Gardener getGardener() {
		return this.gardener;
	}

	public Panda getPanda() {
		return this.panda;
	}


}
