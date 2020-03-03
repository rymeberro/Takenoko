package uqam.inf5153.game.modeles.goals.configurations;
import uqam.inf5153.game.modeles.Position;
import uqam.inf5153.game.modeles.Plot;

public interface Configuration {

    final class RelativePositions {
        private final Position secondPos;
        private final Position thirdPos;
        private final Position forthPos;

        public RelativePositions(Position secondPos, Position thirdPos, Position forthPos) {
            this.secondPos = secondPos;
            this.thirdPos = thirdPos;
            this.forthPos = forthPos;
        }
        public Position getSecondPos() {
            return secondPos;
        }
        public Position getThirdPos() {
            return thirdPos;
        }
        public Position getForthPos() {
            return forthPos;
        }
    }

    String getConfigName();
    String getConfigDescription();
    RelativePositions  getRelativePositions (Position firstPos);
    int  getCardPointValue ();



}
