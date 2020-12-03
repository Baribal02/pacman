package ch.epfl.cs107.play.game.superpacman.area;

import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.math.Vector;

public class Level2 extends SuperPacmanArea {
    public static final DiscreteCoordinates PLAYER_SPAWN_POSITION = new DiscreteCoordinates(15,29);
    @Override
    public void createArea(){
    	super.createArea();

    }
    @Override
    public String getTitle() {
        return "superpacman/Level2";
    }
}
