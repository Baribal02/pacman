package ch.epfl.cs107.play.game.superpacman.actor;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.game.rpg.handler.RPGInteractionVisitor;
import ch.epfl.cs107.play.game.superpacman.handler.SuperPacmanInteractionVisitor;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.window.Canvas;

public class Cherry extends SuperPacManCollectable{
	
	Sprite sprite;
	private final static int CHERRY_SCORE=200;
	public Cherry(Area area, DiscreteCoordinates position) {
		super(area, position);
		this.sprite=new Sprite("superpacman/cherry" , 1, 1.f, this);
		// TODO Auto-generated constructor stub
	}
	
	

	
	@Override
	public void draw(Canvas canvas) {
		if(sprite != null)
			sprite.draw(canvas);
	}
	
	public int getScore() {return CHERRY_SCORE;}
	
	@Override
    public void acceptInteraction(AreaInteractionVisitor v) {
    	((SuperPacmanInteractionVisitor)v).interactWith(this);
  
    	}

}
