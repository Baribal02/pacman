package ch.epfl.cs107.play.game.superpacman.area;

import ch.epfl.cs107.play.game.actor.Actor;
import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Background;
import ch.epfl.cs107.play.game.areagame.actor.Foreground;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.rpg.actor.Door;
import ch.epfl.cs107.play.game.superpacman.actor.Bonus;
import ch.epfl.cs107.play.game.superpacman.actor.Cherry;
import ch.epfl.cs107.play.game.superpacman.actor.Diamond;
import ch.epfl.cs107.play.game.superpacman.actor.Gate;
import ch.epfl.cs107.play.game.superpacman.actor.Key;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.signal.logic.Logic;


public class Level0 extends SuperPacmanArea {
    public static final DiscreteCoordinates PLAYER_SPAWN_POSITION = new DiscreteCoordinates(10,1);
    @Override
    public void createArea(){
    	super.createArea();
    	Key key =  new Key(this,new DiscreteCoordinates(3,4));
    	registerActor(key);
    	registerActor(new Gate(this,Orientation.RIGHT,new DiscreteCoordinates(5,8),key));
    	registerActor(new Gate(this,Orientation.RIGHT,new DiscreteCoordinates(6,8),key));
    	registerActor(new Door("superpacman/Level1",Level1.PLAYER_SPAWN_POSITION,Logic.TRUE,this,Orientation.UP,new DiscreteCoordinates(5,9),new DiscreteCoordinates(6,9)));
    }
    @Override
    public String getTitle() {
        return "superpacman/Level0";
    }
}
