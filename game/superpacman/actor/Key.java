package ch.epfl.cs107.play.game.superpacman.actor;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.game.superpacman.handler.SuperPacmanInteractionVisitor;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.signal.logic.Logic;
import ch.epfl.cs107.play.window.Canvas;

public class Key extends SuperPacManCollectable implements Logic{
	
	Sprite sprite;
	private boolean ramasee;
	public Key(Area area, DiscreteCoordinates position) {
		super(area, position);
		this.sprite=new Sprite("superpacman/key" , 1, 1.f, this);
		this.ramasee=false;
	}
	
	public void estRamasse() {
		ramasee=true;
	}

	
	@Override
	public void draw(Canvas canvas) {
		if(sprite != null)
			sprite.draw(canvas);
	}
	
	public int getScore() {return 0;}


	@Override
	public boolean isOn() {
		// TODO Auto-generated method stub
		return ramasee;
	}




	@Override
	public boolean isOff() {
		// TODO Auto-generated method stub
		return !ramasee;
	}




	
	@Override
    public void acceptInteraction(AreaInteractionVisitor v) {
    	((SuperPacmanInteractionVisitor)v).interactWith(this);
  
    	}

	@Override
	public float getIntensity() {
		if (isOn()) {return (Logic.TRUE).getIntensity();}
		return (Logic.FALSE).getIntensity();
		

	}
}