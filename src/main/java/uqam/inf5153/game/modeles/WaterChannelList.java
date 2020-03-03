package uqam.inf5153.game.modeles;

import java.util.ArrayList;


public class WaterChannelList extends PlacableList<WaterChannel> {

    private ArrayList<WaterChannel> waterChannels;

    public WaterChannelList()
    {
        this.waterChannels = new ArrayList<WaterChannel>();
        WaterChannel waterChannel1 = new WaterChannel(new Position(1,0));
        waterChannels.add(waterChannel1);
        WaterChannel waterChannel2 = new WaterChannel(new Position(-1,0));
        waterChannels.add(waterChannel2);
        WaterChannel waterChannel3 = new WaterChannel(new Position(0.5,1));
        waterChannels.add(waterChannel3);
        WaterChannel waterChannel4 = new WaterChannel(new Position(-0.5,1));
        waterChannels.add(waterChannel4);
        WaterChannel waterChannel5 = new WaterChannel(new Position(0.5,-1));
        waterChannels.add(waterChannel5);
        WaterChannel waterChannel6 = new WaterChannel(new Position(-0.5,-1));
        waterChannels.add(waterChannel6);
    }

    public boolean place(Plot element1, Plot element2, ArrayList<Plot> list) {
        if(verifyIfPlacable(element1,element2, list)){
            double posX = (element1.getPosition().getX() + element2.getPosition().getX())/2;
            double posY = (element1.getPosition().getY() + element2.getPosition().getY())/2;
            WaterChannel waterChannel = new WaterChannel(new Position(posX,posY));
            waterChannels.add(waterChannel);
            return true;
        }else{
            return false;
        }
    }

    public boolean verifyIfPlacable(Plot element1, Plot element2, ArrayList<Plot> list ) {
        if (list.contains(element1) && list.contains(element2)){
            boolean res = true;
            boolean valid = false;
            double posX = (element1.getPosition().getX() + element2.getPosition().getX())/2;
            double posY = (element1.getPosition().getY() + element2.getPosition().getY())/2;
            WaterChannel waterChannel = new WaterChannel(new Position(posX,posY));
            for(WaterChannel w: waterChannels){
                if (w.getPosition().getX() == posX && w.getPosition().getY() == posY){
                    res = false;
                }
            }
            System.out.println(res);
            for (WaterChannel i : waterChannels) {
                if (i.getPosition().getX() == waterChannel.getPosition().getX() + 0.5 &&
                        i.getPosition().getY() == waterChannel.getPosition().getY() + 1) {
                    valid = true;
                } else if (i.getPosition().getX() == waterChannel.getPosition().getX() - 0.5 &&
                        i.getPosition().getY() == waterChannel.getPosition().getY() + 1) {
                    valid = true;
                } else if (i.getPosition().getX() == waterChannel.getPosition().getX() - 0.5 &&
                        i.getPosition().getY() == waterChannel.getPosition().getY() - 1) {
                    valid = true;
                } else if (i.getPosition().getX() == waterChannel.getPosition().getX() + 0.5 &&
                        i.getPosition().getY() == waterChannel.getPosition().getY() - 1) {
                    valid = true;
                }
            }
            return valid && res;
        }else{
            return false;
        }

    }

    @Override
    public ArrayList<Position> getAllPos(){
        ArrayList<Position> list = new ArrayList<Position>();
        for(WaterChannel p: waterChannels){
            list.add(p.getPosition());
        }
        return list;
    }

    @Override
    public ArrayList<WaterChannel> getAll(){
        ArrayList<WaterChannel>list = new ArrayList<WaterChannel>();
        for(WaterChannel p: waterChannels){
            list.add(p);
        }
        return list;
    }
}



