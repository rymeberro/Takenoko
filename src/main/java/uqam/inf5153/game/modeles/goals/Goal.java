package uqam.inf5153.game.modeles.goals;

/*representation des cartes objectifs en general*/

import uqam.inf5153.game.modeles.PlayerBoard;

public abstract class Goal {

  //  public abstract boolean isObjectifSatisfied(PlayerBoard playerBord);

    private int score;

    public Goal(int score)
    {
        this.score = score;
    }

    public abstract String description();
    public abstract boolean isCompleted();

    public int getScore() { return this.score; }

}
