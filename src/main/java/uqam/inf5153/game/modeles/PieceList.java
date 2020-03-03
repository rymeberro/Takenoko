package uqam.inf5153.game.modeles;

import java.util.ArrayList;
import java.util.List;

public class PieceList extends PlacableList<Piece> {
    private ArrayList<Piece> pieces;

    public PieceList()
    {
        this.pieces = new ArrayList<Piece>();
    }

    @Override
    public boolean place(Piece placable) {
        return false;
    }

    //@Override
    public boolean verifyIfPlacable(Piece placable) {
        return false;
    }

    @Override
    public ArrayList<Piece> getAll(){
        ArrayList<Piece> list = new ArrayList<Piece>();
        for(Piece p: this.pieces){
            list.add(p);
        }
        return list;
    }

    @Override
    public ArrayList<Position> getAllPos(){
        ArrayList<Position> list = new ArrayList<Position>();
        for(Piece p: this.pieces){
            list.add(p.getPosition());
        }
        return list;
    }

}
