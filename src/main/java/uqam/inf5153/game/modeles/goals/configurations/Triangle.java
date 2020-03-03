package uqam.inf5153.game.modeles.goals.configurations;

import uqam.inf5153.game.modeles.Position;

public class Triangle implements Configuration {

    public final static int CARD_POINT_VALUE = 4;

    @Override
    public RelativePositions getRelativePositions (Position firstPos){
        Position secondPos = new Position(firstPos.getX()+1, firstPos.getY()+2);
        Position thirdPos = new Position(firstPos.getX()+2, firstPos.getY());
        return new RelativePositions(secondPos, thirdPos, null);
    }

    @Override
    public int  getCardPointValue () {
        return CARD_POINT_VALUE;
    }

    @Override
    public String getConfigName() {
        return "Triangle";
    }

}
