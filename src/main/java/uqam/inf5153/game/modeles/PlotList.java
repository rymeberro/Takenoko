package uqam.inf5153.game.modeles;

import java.util.ArrayList;

public class PlotList extends PlacableList<Plot> {
    private ArrayList<Plot> plots;
    private ArrayList<Position> startingPosition;


    public PlotList()
    {
        this.plots = new ArrayList<Plot>();
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
                if(i.getPosition().getX() -1 == plot.getPosition().getX() &&
                        i.getPosition().getY() +2 == plot.getPosition().getY()){
                    cnt++;
                }
                if(i.getPosition().getX() -2 == plot.getPosition().getX() &&
                        i.getPosition().getY() == plot.getPosition().getY()){
                    cnt++;
                }
                if(i.getPosition().getX() -1 == plot.getPosition().getX() &&
                        i.getPosition().getY() -2 == plot.getPosition().getY()){
                    cnt++;
                }
                if(i.getPosition().getX() +1 == plot.getPosition().getX() &&
                        i.getPosition().getY() +2 == plot.getPosition().getY()){
                    cnt++;
                }
                if(i.getPosition().getX() +2 == plot.getPosition().getX() &&
                        i.getPosition().getY()  == plot.getPosition().getY()){
                    cnt++;
                }
                if(i.getPosition().getX() +1 == plot.getPosition().getX() &&
                        i.getPosition().getY() -2 == plot.getPosition().getY()){
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

    public ArrayList getAll(){
        ArrayList list = new ArrayList();
        for(Plot p: this.plots){
            list.add(p);
        }
        return list;
    }

    public ArrayList getAllPos(){
        ArrayList list = new ArrayList();
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
}
