package ch.epfl.cs107.play.game.superpacman.area;

import ch.epfl.cs107.play.math.Vector;

public class Level0 extends SuperPacmanArea {
    private final Vector PLAYER_SPAWN_POSITION = new Vector(10,1);
    @Override
    public void createArea(){

    }
    @Override
    public String getTitle() {
        return "superpacman/Level0";
    }
}
