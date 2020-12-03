package ch.epfl.cs107.play.game.superpacman.area;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Background;
import ch.epfl.cs107.play.game.areagame.actor.Foreground;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.rpg.actor.Door;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.signal.logic.Logic;

public class Level0 extends SuperPacmanArea {
    public static final DiscreteCoordinates PLAYER_SPAWN_POSITION = new DiscreteCoordinates(10,1);
    @Override
    public void createArea(){
    	super.createArea();
    	registerActor(new Door("superpacman/Level1",Level1.PLAYER_SPAWN_POSITION,Logic.TRUE,this,Orientation.UP,new DiscreteCoordinates(5,9),new DiscreteCoordinates(6,9)));
    }
    @Override
    public String getTitle() {
        return "superpacman/Level0";
    }
}
