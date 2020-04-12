package uqam.inf5153.game.modeles.decks;

import uqam.inf5153.game.modeles.amenagements.Amenagement;
import uqam.inf5153.game.modeles.amenagements.Bassin;
import uqam.inf5153.game.modeles.amenagements.Enclos;
import uqam.inf5153.game.modeles.amenagements.Engrais;

import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Optional;

public class AmenagementsDeck implements Deck<Amenagement>
{
    private LinkedList<Amenagement> listAmenagements;

    public AmenagementsDeck() { this.listAmenagements = new LinkedList<Amenagement>(); }

    @Override
    public Optional<Amenagement> pick()
    {
        try
        {
            return Optional.of(this.listAmenagements.poll());
        } catch (NoSuchElementException e)
        {
            return Optional.empty();
        }
    }

    @Override
    public void init()
    {
        for(int i = 0; i < 3; i++)
        {
            this.listAmenagements.add(new Enclos());
            this.listAmenagements.add(new Engrais());
            this.listAmenagements.add(new Bassin());
        }
        Collections.shuffle(this.listAmenagements);
    }

    @Override
    public boolean isEmpty()
    {
        return this.listAmenagements.isEmpty();
    }
}
