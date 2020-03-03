package uqam.inf5153.game.modeles;

public class WaterChannel implements Placable {

	private Position position;

	public WaterChannel(){
	}

	public WaterChannel(Position position){
		this.position = position;
	}

	@Override
	public Position getPosition() { return this.position; }

	@Override
	public void setPosition(double x, double y) {
		this.position = new Position(x, y);
	}

	@Override
	public String toString() { return this.position.toString(); }
	
}
