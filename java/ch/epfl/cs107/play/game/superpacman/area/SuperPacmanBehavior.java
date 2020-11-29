package ch.epfl.cs107.play.game.superpacman.area;

import ch.epfl.cs107.play.game.areagame.Area;
import ch.epfl.cs107.play.game.areagame.AreaBehavior;
import ch.epfl.cs107.play.game.areagame.actor.Interactable;
import ch.epfl.cs107.play.game.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.game.superpacman.actor.Wall;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.window.Window;

public class SuperPacmanBehavior extends AreaBehavior {
    public enum SuperPacmanCellType{
        //https://stackoverflow.com/questions/25761438/understanding-bufferedimage-getrgb-output-values
        NONE(0), // never used as real content
        WALL ( -16777216), //black
        FREE_WITH_DIAMOND(-1), //white
        FREE_WITH_BLINKY (-65536), //red
        FREE_WITH_PINKY ( -157237), //pink
        FREE_WITH_INKY ( -16724737), //cyan
        FREE_WITH_CHERRY (-36752), //light red
        FREE_WITH_BONUS ( -16478723), //light blue
        FREE_EMPTY ( -6118750); // sort of gray

        final int type;

        SuperPacmanCellType(int type){
            this.type = type;
        }

        public static SuperPacmanBehavior.SuperPacmanCellType toType(int type){
            for(SuperPacmanBehavior.SuperPacmanCellType ict : SuperPacmanBehavior.SuperPacmanCellType.values()){
                if(ict.type == type)
                    return ict;
            }
            // When you add a new color, you can print the int value here before assign it to a type
            System.out.println(type);
            return NONE;
        }
    }

    /**
     * Default Tuto2Behavior Constructor
     * @param window (Window), not null
     * @param name (String): Name of the Behavior, not null
     */
    public SuperPacmanBehavior(Window window, String name){
        super(window, name);
        int height = getHeight();
        int width = getWidth();
        for(int y = 0; y < height; y++) {
            for (int x = 0; x < width ; x++) {
                SuperPacmanBehavior.SuperPacmanCellType color = SuperPacmanBehavior.SuperPacmanCellType.toType(getRGB(height-1-y, x));
                setCell(x,y, new SuperPacmanBehavior.SuperPacmanCell(x,y,color));
            }
        }
    }

    /**
     * Cell adapted to the Tuto2 game
     */
    public class SuperPacmanCell extends AreaBehavior.Cell {
        /// Type of the cell following the enum
        private final SuperPacmanCellType type;

        /**
         * Default Tuto2Cell Constructor
         * @param x (int): x coordinate of the cell
         * @param y (int): y coordinate of the cell
         * @param type (EnigmeCellType), not null
         */
        public  SuperPacmanCell(int x, int y, SuperPacmanBehavior.SuperPacmanCellType type){
            super(x, y);
            this.type = type;
        }

        @Override
        protected boolean canLeave(Interactable entity) {
            return true;
        }

        @Override
        protected boolean canEnter(Interactable entity) {
        }


        @Override
        public boolean isCellInteractable() {
            return true;
        }

        @Override
        public boolean isViewInteractable() {
            return false;
        }

        public boolean [][] neighbors(DiscreteCoordinates position, Area area){
            boolean [][] isNeighbor = new boolean [3][3];
            for(int i = 0; i<3 ; ++i){
                for(int j = 0; j<3; ++j){
                    if(((SuperPacmanCell)getCell(position.x-1+i,position.y-1+j)).type == SuperPacmanCellType.WALL){
                        isNeighbor [i][j]=true;
                    }
                }
            }
            return isNeighbor;
        }
        @Override
        public void acceptInteraction(AreaInteractionVisitor v) {
        }

        public void registerActors(Area area){
             for(int i = 0; i<area.getHeight();++i){
                 for(int j = 0; j<area.getWidth();++j){
                     DiscreteCoordinates position = new DiscreteCoordinates(i,j);
                     if(((SuperPacmanCell)getCell(position.x,position.y)).type == SuperPacmanCellType.WALL){
                         area.registerActor(new Wall(area, position, neighbors(position, area)));
                     }
                 }
             }
        }
    }
}

