package ch.epfl.cs107.play.game.areagame.actor;

import java.util.Collections;
import java.util.List;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.game.rpg.handler.RPGInteractionVisitor;
import ch.epfl.cs107.play.math.DiscreteCoordinates;

public abstract class CollectableAreaEntity extends AreaEntity{
	Sprite sprite;
	public CollectableAreaEntity(Area area, DiscreteCoordinates position) {
		super(area, Orientation.DOWN, position); // Orientation arbitraire ,

	}
	public CollectableAreaEntity(Area area,Orientation orientation, DiscreteCoordinates position) {
		super(area, orientation, position); // Orientation arbitraire ,

	}

	
	
	  
	@Override
    public List<DiscreteCoordinates> getCurrentCells() {
        return Collections.singletonList(getCurrentMainCellCoordinates());
    }
	

}

