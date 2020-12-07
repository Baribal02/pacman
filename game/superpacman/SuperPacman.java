package ch.epfl.cs107.play.game.superpacman;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.actor.Orientation;
import ch.epfl.cs107.play.game.rpg.RPG;
import ch.epfl.cs107.play.game.superpacman.actor.SuperPacmanPlayer;
import ch.epfl.cs107.play.game.superpacman.area.Level0;
import ch.epfl.cs107.play.game.superpacman.area.Level1;
import ch.epfl.cs107.play.game.superpacman.area.Level2;
import ch.epfl.cs107.play.game.tutosSolution.actor.GhostPlayer;
import ch.epfl.cs107.play.game.tutosSolution.area.tuto2.Ferme;
import ch.epfl.cs107.play.game.tutosSolution.area.tuto2.Village;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.window.Window;

public class SuperPacman extends RPG {
	private final String[] areas = {"superpacman/Level0", "superpacman/Level1","superpacman/Level2"};
	private int areaIndex;
	
	private void createAreas(){

		addArea(new Level0());
		addArea(new Level1());
		addArea(new Level2());

	}

	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);

	}
	
	
	@Override
	public boolean begin(Window window, FileSystem fileSystem) {


		if (super.begin(window, fileSystem)) {

			createAreas();
			areaIndex = 0;
			Area area = setCurrentArea(areas[areaIndex], true);
			initPlayer(new SuperPacmanPlayer(area,Level0.PLAYER_SPAWN_POSITION));
			area.registerActor(this.getPlayer());
			area.setViewCandidate(this.getPlayer());
			return true;
		}
		return false;
	}
	
	
	
	
    @Override
    public String getTitle(){
        return "Super Pac-Man";
    }
}
