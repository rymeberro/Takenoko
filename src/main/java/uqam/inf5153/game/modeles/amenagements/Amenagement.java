package uqam.inf5153.game.modeles.amenagements;

public interface Amenagement extends EntityListener
{

    /** Get le type d'amenagement
     *
     * @return
     */
    public String getAmenagement();

    public void onGardenerLandsOnArrangedPlot();
    public void onPandaLandsOnArrangedPlot();

}
