package uqam.inf5153.game.modeles;

import java.util.ArrayList;

public class PlotList extends PlacableList<Plot> {
    private ArrayList<Plot> plots;
    private ArrayList<Position> startingPosition;


    public PlotList()
    {
        this.plots = new ArrayList<Plot>();
        this.plots.add(new Plot(new Position(0, 0), "ETANG"));
        this.startingPosition = new ArrayList<Position>();
        this.startingPosition.add(new Position(-1,2));
        this.startingPosition.add(new Position(-2,0));
        this.startingPosition.add(new Position(-1,-2));
        this.startingPosition.add(new Position(1,2));
        this.startingPosition.add(new Position(2,0));
        this.startingPosition.add(new Position(1,-2));
    }

    @Override
    public boolean place(Plot plot) {
        if(verifyIfPlacable(plot)){
            plots.add(plot);
            return true;
        }else{
            return false;
        }
    }

    public boolean verifyIfPlacable(Plot plot) {
        if(this.startingPosition.contains(plot.getPosition()) && !this.plots.contains(plot)){
            return true;
        }else if(!this.plots.contains(plot)){
            int cnt = 0;
            for(Plot i: plots){
                if(i.getPosition().getX() == plot.getPosition().getX() -1 &&
                        i.getPosition().getY() == plot.getPosition().getY() +2){
                    if(i.getColor().equals("ETANG")) return true;
                    cnt++;
                }
                if(i.getPosition().getX() == plot.getPosition().getX() -2 &&
                        i.getPosition().getY() == plot.getPosition().getY()){
                    if(i.getColor().equals("ETANG")) return true;
                    cnt++;
                }
                if(i.getPosition().getX() == plot.getPosition().getX() -1 &&
                        i.getPosition().getY() == plot.getPosition().getY() -2){
                    if(i.getColor().equals("ETANG")) return true;
                    cnt++;
                }
                if(i.getPosition().getX() == plot.getPosition().getX() +1 &&
                        i.getPosition().getY() == plot.getPosition().getY() +2){
                    if(i.getColor().equals("ETANG")) return true;
                    cnt++;
                }
                if(i.getPosition().getX() == plot.getPosition().getX() +2 &&
                        i.getPosition().getY()  == plot.getPosition().getY()){
                    if(i.getColor().equals("ETANG")) return true;
                    cnt++;
                }
                if(i.getPosition().getX() == plot.getPosition().getX() +1 &&
                        i.getPosition().getY() == plot.getPosition().getY() -2){
                    if(i.getColor().equals("ETANG")) return true;
                    cnt++;
                }
            }
            if (cnt >=2){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public ArrayList<Plot> getAll(){
        ArrayList<Plot> list = new ArrayList<Plot>();
        for(Plot p: this.plots){
            list.add(p);
        }
        return list;
    }

    @Override
    public ArrayList<Position> getAllPos(){
        ArrayList<Position> list = new ArrayList<Position>();
        for(Plot p: this.plots){
            list.add(p.getPosition());
        }
        return list;
    }

    public boolean isPlotIrrigated(Plot element, ArrayList<WaterChannel> wtc) {
        boolean res = false;
        if (!this.plots.contains(element)){
            return false;
        }else{
            if(element.getAmenagement() != null)
                if(element.getAmenagement().getAmenagement().equals("Bassin")) return true;
            for(WaterChannel w: wtc){
                if (element.getPosition().getX() + 1 == w.getPosition().getX()
                        && element.getPosition().getY() == w.getPosition().getY()){
                    res = true;
                }else if (element.getPosition().getX() -1 == w.getPosition().getX()
                        && element.getPosition().getY() == w.getPosition().getY()){
                    res = true;
                }else if (element.getPosition().getX() +0.5 == w.getPosition().getX()
                        && element.getPosition().getY() -1 == w.getPosition().getY()){
                    res = true;
                }else if (element.getPosition().getX() -0.5 == w.getPosition().getX()
                        && element.getPosition().getY() -1 == w.getPosition().getY()){
                    res = true;
                }else if (element.getPosition().getX() +0.5 == w.getPosition().getX()
                        && element.getPosition().getY() +1 == w.getPosition().getY()){
                    res = true;
                }else if (element.getPosition().getX() +0.5 == w.getPosition().getX()
                        && element.getPosition().getY() +1 == w.getPosition().getY()){
                    res = true;
                }
            }
        }
        return res;
    }

    public boolean addBamboo(Plot plot){
        for(Plot i: plots){
            if (plot.equals(i)){
                return i.addBamboo();
            }
        }
        return false;
    }

    public boolean removeBamboo(Plot plot){
        for(Plot i: plots){
            if (plot.equals(i)){
                return i.removeBamboo();
            }
        }
        return false;
    }
}
