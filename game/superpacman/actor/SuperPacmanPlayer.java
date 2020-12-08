package ch.epfl.cs107.play.game.superpacman.actor;

import ch.epfl.cs107.play.game.actor.TextGraphics;
import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.*;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.game.rpg.actor.Door;
import ch.epfl.cs107.play.game.rpg.actor.Player;
import ch.epfl.cs107.play.game.rpg.actor.RPGSprite;
import ch.epfl.cs107.play.game.superpacman.area.SuperPacmanArea;
import ch.epfl.cs107.play.game.superpacman.handler.SuperPacmanInteractionVisitor;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Keyboard;

import java.awt.*;
import java.util.Collections;
import java.util.List;
import java.awt.Color;
import java.util.Collections;
import java.util.List;

import ch.epfl.cs107.play.game.actor.TextGraphics;
import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.MovableAreaEntity;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.areagame.actor.Sprite;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Button;
import ch.epfl.cs107.play.window.Canvas;
import ch.epfl.cs107.play.window.Keyboard;


public class SuperPacmanPlayer extends Player {
	private class SuperPacmanPlayerHandler implements SuperPacmanInteractionVisitor{
		 public void interactWith(Door door){
			 setIsPassingADoor(door);
			 }
		 public void interactWith(Diamond dia) {
			 if(!dia.collected) {
			 dia.isWalkedOn();
			 score+=dia.getScore();
			 ((SuperPacmanArea) getOwnerArea()).collectDiamond();
			
			 }
			 
		 }
		 public void interactWith(Cherry cher) {
			 if (!cher.collected) {
				 cher.isWalkedOn();
				 score+=cher.getScore();
				
			 }
			 
			
		 }
		 public void interactWith(Bonus bonus) {
			 if(!bonus.collected) {
				 
			
			 bonus.isWalkedOn();
			 
			 }
			 // attribut invincible = true;
		 }
		 public void interactWith(Key key) {
			 if(!key.collected) {
			 key.isWalkedOn();
			 key.estRamasse();
			
			 }
		 }
	}

    
    
    private Animation[] animations;
    private Animation animation;
    private Orientation desiredOrientation;
    private SuperPacmanPlayerHandler handler;
    
    
    private int ptVie;
    private int score;
    public final static int ptVieMax=5;
    private final static int ptVieInit=3;
    private SuperPacmanPlayerStatusGUI gui;
    
    //getteur
    public int getPtvie() {return ptVie;}
    public int getScore() {return score;}
    
    /// Animation duration in frame number

    public final static int ANIMATION_DURATION =6;
    /**
     * Demo actor
     *
     */
    public SuperPacmanPlayer(Area owner, DiscreteCoordinates coordinates) {
        super(owner, Orientation.RIGHT, coordinates);
       Sprite[][] sprites = RPGSprite.extractSprites("superpacman/pacman", 4, 1, 1, this, 64, 64,
                new Orientation[] {Orientation.DOWN, Orientation.LEFT, Orientation.UP, Orientation.RIGHT});
         animations = Animation.createAnimations(ANIMATION_DURATION, sprites);
        resetMotion();
        handler = new SuperPacmanPlayerHandler();
        ptVie=ptVieInit;
        score = 0; 
        gui= new SuperPacmanPlayerStatusGUI(this);
    }
    @Override
    public void draw(Canvas canvas) {
    	animation.draw(canvas);
    	gui.draw(canvas);
       
    }

    @Override
    public void update(float deltaTime) {
        Keyboard keyboard= getOwnerArea().getKeyboard();
        
        desiredOrientation = desiredOrientation(keyboard);
	      
        animation = animations[getOrientation().ordinal()];
        		if (!isDisplacementOccurs()) { 
        		   if (getOwnerArea().canEnterAreaCells(this,Collections.singletonList(getCurrentMainCellCoordinates().jump(desiredOrientation.toVector())))) {
        		         orientate(desiredOrientation);
        		    }
        		   move(ANIMATION_DURATION);
        		}
        		if(isDisplacementOccurs()) {
        		animation.update(deltaTime);
        		} else {animation.reset();}

        		super.update(deltaTime);

    }

    /**
     * Orientate or Move this player in the given orientation if the given button is down
     * @param orientation (Orientation): given orientation, not null
     * @param b (Button): button corresponding to the given orientation, not null
     */
 
    private Orientation desiredOrientation( Keyboard keyboard) {
        Button key = keyboard.get(Keyboard.UP);
        if (key.isDown()) {
            return Orientation.UP;
        }
        key = keyboard.get(Keyboard.DOWN);
        if (key.isDown()) {
            return Orientation.DOWN;
        }
        key = keyboard.get(Keyboard.RIGHT);
        if (key.isDown()) {
            return Orientation.RIGHT;
        }
        key = keyboard.get(Keyboard.LEFT);
        if (key.isDown()) {
            return Orientation.LEFT;
        }
        if(desiredOrientation==null) { return getOrientation();}
        return desiredOrientation;
    }
    /**
     * Leave an area by unregister this player
     */
    public void leaveArea(){
        getOwnerArea().unregisterActor(this);
    }

    /**
     *
     * @param area (Area): initial area, not null
     * @param position (DiscreteCoordinates): initial position, not null
     */
    
   

    ///Ghost implements Interactable

    @Override
    public boolean takeCellSpace() {
        return true;
    }

    @Override
    public boolean isCellInteractable() {
        return true;
    }

    @Override
    public boolean isViewInteractable() {
        return true;
    }
    @Override
    public List<DiscreteCoordinates> getCurrentCells() {
        return Collections.singletonList(getCurrentMainCellCoordinates());
    }

    @Override
    public List<DiscreteCoordinates> getFieldOfViewCells() {
        return null;
    }

    @Override
    public boolean wantsCellInteraction() {
        return true;
    }

    @Override
    public boolean wantsViewInteraction() {
        return false;
    }

    @Override
    public void interactWith(Interactable other) {
        other.acceptInteraction(handler);
    }

    @Override
    public void acceptInteraction(AreaInteractionVisitor v) {
    	((SuperPacmanInteractionVisitor)v).interactWith(this);
    	}
}
