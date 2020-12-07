package ch.epfl.cs107.play.game.superpacman.area;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.superpacman.area.SuperPacmanBehavior;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.signal.logic.Logic;
import ch.epfl.cs107.play.window.Window;

public class SuperPacmanArea extends Area implements Logic{
    private SuperPacmanBehavior behavior;
    private int totalDiamond;
    private int collectedDiamond;
    @Override
    public boolean begin(Window window, FileSystem fileSystem){
        if(super.begin(window, fileSystem)){
            behavior = new SuperPacmanBehavior(window, getTitle());
            setBehavior(behavior);
            createArea();
            totalDiamond=0;
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
        behavior.registerActors((Area)this);
        
    }
    @Override
    public String getTitle() {
        return "Super Pac-Man Area";
    }
    @Override
    public final float getCameraScaleFactor(){
        return 50.f;
    }
    
    public void setDiamond(int diamond) {totalDiamond =diamond ;

    }
    public void collectDiamond() {collectedDiamond ++;}
    public void test() {System.out.println("total diamond : "+totalDiamond);
    System.out.println("Collected diamond :"+collectedDiamond);
    System.out.println("signal ison "+isOn());
    System.out.println("Signal isOFF "+isOff());
    }
    
	@Override
	public boolean isOn() {

		// TODO Auto-generated method stub
		return (collectedDiamond>10);
	}
	@Override
	public boolean isOff() {
		// TODO Auto-generated method stub
		return (collectedDiamond<10);
	}
	@Override
	public float getIntensity() {
		return 0;
	}
}
