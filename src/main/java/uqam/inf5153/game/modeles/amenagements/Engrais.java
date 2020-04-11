package uqam.inf5153.game.modeles.amenagements;

public class Engrais implements Amenagement
{
    private String amenagementName = "Engrais";

    @Override
    public String getAmenagement()
    {
        return amenagementName;
    }
}
