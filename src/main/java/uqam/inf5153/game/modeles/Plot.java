package uqam.inf5153.game.modeles;

public class Plot implements Placable {

	private Position position;
	private String color;
	private Plot plot;


	//constructeur
	public Plot (Position position, String color){
		this.color = color;
		this.position= position;
	}

	public Plot (){

	}

	@Override
	public Position getPosition() {
		return this.position;
	}

	@Override
	public void setPosition(double x, double y) {
		this.position = new Position(x,y);
	}

	@Override
	public void setPosition(Position position) {
		this.position = position;
	}

	public String getColor ( ) {
		return color;
	}
}
