package uqam.inf5153.game.modeles.goals.configurations;

import uqam.inf5153.game.modeles.Position;


public class StaightLine implements Configuration {

	public final static int CARD_POINT_VALUE = 2;

	@Override
	public RelativePositions getRelativePositions (Position firstPos){
		Position secondPos = new Position(firstPos.getX()-1, firstPos.getY()+2);
		Position thirdPos = new Position(firstPos.getX()-2, firstPos.getY()+4);
		return new RelativePositions(secondPos, thirdPos, null);
	}

	@Override
	public int  getCardPointValue () {
		return CARD_POINT_VALUE;
	}

	@Override
	public String getConfigName() {
		return "StaightLine";
	}

}
