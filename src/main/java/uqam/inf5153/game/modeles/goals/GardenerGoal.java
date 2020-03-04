package uqam.inf5153.game.modeles.goals;

import uqam.inf5153.game.modeles.Board;
import uqam.inf5153.game.modeles.PlayerBoard;

public class GardenerGoal extends Goal {

    private int cardPointValue;

    /*
     * Constructeur d'une carte objectif jardinier
     * */
    public GardenerGoal () {
        super(0);
    }


    @Override
    public String description() {
        return null;
    }

    @Override
    public boolean isCompleted(Board board) {
        return false;
    }
}
