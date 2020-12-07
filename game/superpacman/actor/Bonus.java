package ch.epfl.cs107.play.game.superpacman.actor;

import java.util.List;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Animation;
import ch.epfl.cs107.play.game.areagame.actor.CollectableAreaEntity;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.game.rpg.actor.RPGSprite;
import ch.epfl.cs107.play.game.superpacman.handler.SuperPacmanInteractionVisitor;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.window.Canvas;

public class Bonus extends SuperPacManCollectable{
	
	Animation animation;
	public Bonus(Area area, DiscreteCoordinates position) {
		super(area, position);
		Sprite[] sprite = RPGSprite.extractSprites("superpacman/coin", 4, 1, 1,
				this , 16, 16);
		animation = new Animation(SuperPacmanPlayer.ANIMATION_DURATION,sprite);
	}
	
	
	
	@Override
	public void draw(Canvas canvas) {
		animation.draw(canvas);
		
	}
	
	public int getScore() {return 0;}

	@Override
	public void update(float deltaTime) {
		animation.update(deltaTime);
	}
	
	@Override
    public void acceptInteraction(AreaInteractionVisitor v) {
    	((SuperPacmanInteractionVisitor)v).interactWith(this);
  
    	}
}

