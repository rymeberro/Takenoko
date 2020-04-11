package uqam.inf5153.game.modeles.amenagements;

public class Bassin implements Amenagement
{
    private String amenagementName = "Bassin";

    @Override
    public String getAmenagement()
    {
        return amenagementName;
    }
}
