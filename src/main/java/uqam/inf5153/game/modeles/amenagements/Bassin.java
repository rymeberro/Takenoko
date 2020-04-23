package uqam.inf5153.game.modeles.amenagements;

import uqam.inf5153.game.modeles.Plot;
import uqam.inf5153.game.modeles.Position;

public class Bassin extends ArrangedPlot
{

    public Bassin(Position position, String color)
    {
        super(position, color);
        super.addBamboo();
    }

    @Override
    public void onGardenerLandsOnArrangedPlot() {
        super.addBamboo();
    }

    @Override
    public void onPandaLandsOnArrangedPlot() {
        super.removeBamboo();
    }

    @Override
    public String getAmenagement()
    {
        return "Bassin";
    }

}
