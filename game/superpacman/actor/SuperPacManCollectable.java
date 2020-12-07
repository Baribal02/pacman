package ch.epfl.cs107.play.game.superpacman.actor;

import java.util.List;


import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.CollectableAreaEntity;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.game.rpg.handler.RPGInteractionVisitor;
import ch.epfl.cs107.play.game.superpacman.handler.SuperPacmanInteractionVisitor;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.window.Canvas;

abstract public class SuperPacManCollectable extends CollectableAreaEntity {
	public boolean collected;

	public SuperPacManCollectable(Area area, DiscreteCoordinates position) {
		super(area, position);
		collected=false;
	}
	public SuperPacManCollectable(Area area,Orientation orientation ,DiscreteCoordinates position) {
		super(area,orientation,position);
		collected=false;
	}


	@Override
	public boolean takeCellSpace() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCellInteractable() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isViewInteractable() {
		// TODO Auto-generated method stub
		return false;
	}


	

	public void isWalkedOn() {
		getOwnerArea().unregisterActor(this);
		collected =true;
	}
	abstract public int getScore();
	@Override
    public void acceptInteraction(AreaInteractionVisitor v) {
    	((SuperPacmanInteractionVisitor)v).interactWith(this);
  
    	}
}

