package uqam.inf5153.game.modeles;

import java.util.ArrayList;
import java.util.List;

public abstract class PlacableList<T extends Placable> {
    ArrayList<T> list;

    PlacableList(){
        list = new ArrayList<T>();
    }

    public boolean place(T placable) {
        if (!list.contains(placable)){
            list.add(placable);
            return true;
        }else{
            return false;
        }
    }

    public abstract List<T> getAll();
    public abstract List<Position> getAllPos();

}
