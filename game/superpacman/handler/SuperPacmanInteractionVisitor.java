package ch.epfl.cs107.play.game.superpacman.handler;

import ch.epfl.cs107.play.game.rpg.actor.Door;
import ch.epfl.cs107.play.game.rpg.handler.RPGInteractionVisitor;
import ch.epfl.cs107.play.game.superpacman.actor.Bonus;
import ch.epfl.cs107.play.game.superpacman.actor.Cherry;
import ch.epfl.cs107.play.game.superpacman.actor.Diamond;
import ch.epfl.cs107.play.game.superpacman.actor.Gate;
import ch.epfl.cs107.play.game.superpacman.actor.Key;
import ch.epfl.cs107.play.game.superpacman.actor.SuperPacManCollectable;
import ch.epfl.cs107.play.game.superpacman.actor.SuperPacmanPlayer;




public interface SuperPacmanInteractionVisitor extends RPGInteractionVisitor {
	
	default void interactWith(SuperPacmanPlayer superPacmanPlayer){
        // by default the interaction is empty
    }
	default void interactWith(Diamond dia) {}
	default void interactWith(Cherry cher) {}
	default void interactWith(Bonus b) {}
	default void interactWith(SuperPacManCollectable coll) {}
	default void interactWith(Gate gate) {}
	default void interactWith(Key key) {}
}

