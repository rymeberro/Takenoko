package uqam.inf5153.game.modeles.amenagements;

import uqam.inf5153.game.modeles.Position;

public class Engrais extends ArrangedPlot
{

    public Engrais(Position position, String color)
    {
        super(position, color);
    }

    @Override
    public void onGardenerLandsOnArrangedPlot() {
        System.out.println("L'aménagement [" + this.getAmenagement() + "] de " + super.toString() +  " permet une double pousse sur cette parcelle !");
        super.addBamboo();
        super.addBamboo(); // <- Effet special de l'enclos
    }

    @Override
    public void onPandaLandsOnArrangedPlot() {
        super.removeBamboo();
    }

    @Override
    public String getAmenagement()
    {
        return "Engrais";
    }

}
