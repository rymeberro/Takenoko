package uqam.inf5153.game.modeles.amenagements;

import uqam.inf5153.game.modeles.Position;

public class Enclos extends ArrangedPlot
{

    public Enclos(Position position, String color)
    {
        super(position, color);
    }

    @Override
    public void onGardenerLandsOnArrangedPlot() {
        super.addBamboo();
    }

    @Override
    public void onPandaLandsOnArrangedPlot() {
        System.out.println("L'aménagement [" + this.getAmenagement() + "] de " + super.toString() +  " prévient la gourmandise du Panda ! Il ne dégustera pas de bambou ici.");
        //super.removeBamboo(); <- Effet special de l'enclos
    }

    @Override
    public String getAmenagement()
    {
        return "Enclos";
    }

}
