package uqam.inf5153.game.modeles;

import java.util.ArrayList;

public class Gardener implements Placable {
	
	private Position position;

	Gardener(double x, double y){
		this.position = new Position(x,y);
	}

	@Override
	public Position getPosition() { return this.position; }

	@Override
	public void setPosition(double x, double y) {
		this.position = new Position(x,y);
	}

	@Override
	public void setPosition(Position position) {
		this.position = position;
	}


	public boolean moveTo(double x, double y, ArrayList<Plot> list) {
		Position pos = new Position(x, y);
		if (verifyIfPlacable(pos, list)) {
			this.position = pos;
			return true;
		} else {
			return false;
		}
	}

	private boolean verifyIfPlacable(Position pos, ArrayList<Plot> list){
		for(Plot p: list){
			if (p.getPosition().equals(pos)){
				return true;
			}
		}
		return false;
	}
}
