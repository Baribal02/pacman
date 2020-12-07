package ch.epfl.cs107.play.game.superpacman.actor;

import java.util.Collections;
import java.util.List;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.AreaEntity;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.math.RegionOfInterest;
import ch.epfl.cs107.play.signal.Signal;
import ch.epfl.cs107.play.signal.logic.Logic;
import ch.epfl.cs107.play.signal.logic.LogicGate;
import ch.epfl.cs107.play.window.Canvas;

public class Gate extends AreaEntity{

		private Logic logic;
		private Sprite sprite;
	public Gate(Area area, Orientation orientation, DiscreteCoordinates position,Logic logic) {
		super(area, orientation, position);
		this.logic=logic;
		if (orientation.equals(Orientation.UP)|| orientation.equals(Orientation.DOWN)) {
		this.sprite=new Sprite("superpacman/gate" , 1, 1.f, this,new RegionOfInterest(0, 0, 64, 64));
		} else {
			this.sprite=new Sprite("superpacman/gate" , 1, 1.f, this,new RegionOfInterest(0, 64, 64, 64));	
		}
	}


	@Override
    public List<DiscreteCoordinates> getCurrentCells() {
        return Collections.singletonList(getCurrentMainCellCoordinates());
    }
	

	@Override
	public boolean takeCellSpace() {
		return logic.isOff();
	}

	@Override
	public boolean isCellInteractable() {
		return false;
	}

	@Override
	public boolean isViewInteractable() {
		return false;
		
	}

	@Override
	public void acceptInteraction(AreaInteractionVisitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Canvas canvas) {
		if(sprite != null && logic.isOff())
			sprite.draw(canvas);
	}
}



