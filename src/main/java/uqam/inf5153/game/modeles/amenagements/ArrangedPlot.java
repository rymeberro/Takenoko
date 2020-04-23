package uqam.inf5153.game.modeles.amenagements;

import uqam.inf5153.game.modeles.Plot;
import uqam.inf5153.game.modeles.Position;

/**
 * Représente une parcelle avec un amenagement
 */
public abstract class ArrangedPlot extends Plot implements Amenagement {

    public ArrangedPlot(Position position, String color)
    {
        super(position, color);
    }

    @Override
    public void onGardenerLandsOn()
    {
        System.out.println("Gardener lands on " + this.getAmenagement());
        this.onGardenerLandsOnArrangedPlot();
    }

    @Override
    public void onPandaLandsOn()
    {
        System.out.println("Panda lands on " + this.getAmenagement());
        this.onPandaLandsOnArrangedPlot();
    }

    @Override
    public String toString() { return "[" + this.getAmenagement() + "] " + super.toString(); }

}
