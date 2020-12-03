package ch.epfl.cs107.play.game.superpacman.area;

import ch.epfl.cs107.play.game.areagame.Cell;
import ch.epfl.cs107.play.game.areagame.actor.Interactable;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.game.actor.Entity;
import ch.epfl.cs107.play.game.areagame.Cell;
import ch.epfl.cs107.play.game.areagame.actor.Interactable;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;


public class SuperPacmanCell extends Cell {
    private final SuperPacmanBehavior.SuperPacmanCellType type;

    public SuperPacmanCell(int x, int y, SuperPacmanBehavior.SuperPacmanCellType type){
        super(x, y);
        this.type = type;

    }
    @Override
    public boolean isCellInteractable(){
        return true;
    }
    @Override
    public boolean isViewInteractable(){
        return false;
    }
    @Override
    public void acceptInteraction(AreaInteractionVisitor v){

    }

    @Override
    protected boolean canLeave(Interactable entity) {
        return true;
    }

    @Override
    protected boolean canEnter(Interactable entity) {
    	return true;
       //return entity.takeCellSpace();
    }
}