package uqam.inf5153.game.modeles.amenagements;

public class Enclos implements Amenagement
{
    private String amenagementName = "Enclos";

    @Override
    public String getAmenagement()
    {
        return amenagementName;
    }
}
