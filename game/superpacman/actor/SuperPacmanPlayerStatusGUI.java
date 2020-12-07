package ch.epfl.cs107.play.game.superpacman.actor;

import java.awt.Color;

import ch.epfl.cs107.play.game.actor.Graphics;
import ch.epfl.cs107.play.game.actor.ImageGraphics;
import ch.epfl.cs107.play.game.actor.TextGraphics;
import ch.epfl.cs107.play.game.areagame.io.ResourcePath;
import ch.epfl.cs107.play.math.RegionOfInterest;
import ch.epfl.cs107.play.math.TextAlign;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Canvas;

public class SuperPacmanPlayerStatusGUI implements Graphics {
	private SuperPacmanPlayer player;
	// A FAIRE 
	/* 
	 * tester la valeur 100 ligne 
	 * tester les 1.f dans la construction du score 
	 * tester les anchor
	 */
	
	public SuperPacmanPlayerStatusGUI(SuperPacmanPlayer player) {
		this.player=player;
	}

	@Override
	public void draw(Canvas canvas) {
		int ptVie = player.getPtvie();
		
		int scores = player.getScore();
		float width = canvas.getScaledWidth();
		float height = canvas.getScaledHeight();
		Vector anchor = canvas.getTransform().getOrigin()
		.sub(new Vector(width/2, height/2));
		
		
		
		
		for (int i=0;i<SuperPacmanPlayer.ptVieMax;i++) {
			int m=(ptVie>i)?0:64;
		
		
		ImageGraphics life = new
				ImageGraphics(ResourcePath.getSprite("superpacman/lifeDisplay"),
				1.f, 1.f, new RegionOfInterest(m, 0, 64, 64),
				anchor.add(new Vector(0.3f+i, height - 1.375f)), 1, 100);// 100 valeur arbitraire
				life.draw(canvas);
		}
	
		Vector anchor2 = canvas.getTransform().getOrigin().sub(new Vector(width/2-7, -height/2+1.3f));
		
		TextGraphics score = new TextGraphics ("SCORE : "+scores,1.1f,Color.YELLOW,Color.BLACK,0.02f,false,false,anchor2); // prendre un
		//                                    (String text, float fontSize, Color fillColor, Color outlineColor, float thickness, boolean bold, boolean italics, Vector anchor) {

		score.draw(canvas);
		
		
		
		
		
		
	}

}

