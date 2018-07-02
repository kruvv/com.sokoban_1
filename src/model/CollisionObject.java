package model;

import org.apache.log4j.Logger;

public abstract class CollisionObject extends GameObject {

    private static final Logger logCO = Logger.getLogger(CollisionObject.class);

    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public CollisionObject(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        switch (direction) {
            case LEFT: {
                logCO.info("left");
                return (getX() - Model.FIELD_CELL_SIZE == gameObject.getX() && gameObject.getY() == this.getY()) ? true : false;
            }
            case RIGHT: {
                logCO.info("rihgt");
                return (getX() + Model.FIELD_CELL_SIZE == gameObject.getX() && gameObject.getY() == this.getY()) ? true : false;
            }
            case DOWN: {
                logCO.info("down");
                return (gameObject.getX() == this.getX() && getY() + Model.FIELD_CELL_SIZE == gameObject.getY()) ? true : false;
            }
            case UP: {
                logCO.info("up");
                return (gameObject.getX() == this.getX() && getY() - Model.FIELD_CELL_SIZE == gameObject.getY()) ? true : false;
            }
            default:
                return false;
        }
    }
}
