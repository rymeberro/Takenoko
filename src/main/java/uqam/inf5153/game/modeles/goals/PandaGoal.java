package uqam.inf5153.game.modeles.goals;

import uqam.inf5153.game.modeles.PlayerBoard;

public class PandaGoal extends Goal {

    private int cardPointValue;

    /*
     * Constructeur d'une carte objectif panda
     * */
    public PandaGoal ( ) {
        super(0);
    }


    @Override
    public String description() {
        return null;
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}
