package ch.epfl.cs107.play.game.superpacman.actor;

import java.util.List;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.game.rpg.handler.RPGInteractionVisitor;
import ch.epfl.cs107.play.game.superpacman.handler.SuperPacmanInteractionVisitor;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.window.Canvas;

public class Diamond extends SuperPacManCollectable{
	
	Sprite sprite;
	private final static int  DIAMOND_SCORE=10;
	public Diamond(Area area, DiscreteCoordinates position) {
		super(area, position);
		this.sprite=new Sprite("superpacman/diamond" , 1, 1.f, this);
	}
	
	

	
	@Override
	public void draw(Canvas canvas) {
		if(sprite != null)
			sprite.draw(canvas);
	}
	
	public int getScore() {return DIAMOND_SCORE;}
	
	@Override
    public void acceptInteraction(AreaInteractionVisitor v) {
    	((SuperPacmanInteractionVisitor)v).interactWith(this);
  
    	}
}