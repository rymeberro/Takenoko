package uqam.inf5153.game.modeles;

import uqam.inf5153.game.modeles.amenagements.Amenagement;

public class Plot implements Placable {

	private Position position;
	private String color;
	private int id;
	private Amenagement amenagement;

	private static int instance_id = 0;

	//constructeur
	public Plot (Position position, String color){
		this.color = color;
		this.position= position;
		this.id = Plot.instance_id;
		Plot.instance_id++;
	}

	public Plot(){}

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

	@Override
	public String toString() { return this.color + " at " + this.position; }

	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(!(o instanceof Plot)) return false;
		Plot plot = (Plot) o;
		return plot.getPosition().equals(this.getPosition()) && this.getColor().equals(plot.getColor());
	}

	public void setAmenagement(Amenagement i_amenagement)
	{
		this.amenagement = i_amenagement;
	}
}
