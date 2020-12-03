package ch.epfl.cs107.play.game.superpacman.area;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.superpacman.area.SuperPacmanBehavior;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.window.Window;

public class SuperPacmanArea extends Area {
    private SuperPacmanBehavior behavior;
    @Override
    public boolean begin(Window window, FileSystem fileSystem){
        if(super.begin(window, fileSystem)){
            behavior = new SuperPacmanBehavior(window, getTitle());
            setBehavior(behavior);
            createArea();
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
        return 15.f;
    }
}
