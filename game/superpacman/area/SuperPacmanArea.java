package ch.epfl.cs107.play.game.superpacman.area;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.superpacman.area.SuperPacmanBehavior;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.signal.logic.Logic;
import ch.epfl.cs107.play.window.Window;

public class SuperPacmanArea extends Area implements Logic{
    private SuperPacmanBehavior behavior;

    private int collectedDiamond;
    @Override
    public boolean begin(Window window, FileSystem fileSystem){
        if(super.begin(window, fileSystem)){
            behavior = new SuperPacmanBehavior(window, getTitle());
            setBehavior(behavior);
            createArea();
            
            collectedDiamond=0;
            return true;
        }
        return false;
    }
    @Override
    public void update(float delta){
        super.update(delta);
    }
    @Override
    public void end(){

    }
    public void createArea() {
        behavior.registerActors(this);
        
    }
    @Override
    public String getTitle() {
        return "Super Pac-Man Area";
    }
    @Override
    public final float getCameraScaleFactor(){
        return 50.f;
    }
    
   
    public void collectDiamond() {collectedDiamond ++;}
   
    
	@Override
	public boolean isOn() {

		// TODO Auto-generated method stub
		return (collectedDiamond==behavior.getTotalDiamond());
	}
	@Override
	public boolean isOff() {
		// TODO Auto-generated method stub
		return (collectedDiamond!=behavior.getTotalDiamond());
	}
	@Override
	public float getIntensity() {
		return 0;
	}
}
