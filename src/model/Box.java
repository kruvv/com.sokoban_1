package model;

import java.awt.*;

public class Box extends CollisionObject implements Movable {

    public Box(int x, int y) {
        super(x, y);
    }


    public void move(int x, int y) {

        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.ORANGE);
        int leftUpperCornerX = getX() - getWidth() / 2;
        int leftUpperCornerY = getY() - getHeight() / 2;

        graphics.drawRect(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
        graphics.fillRect(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());

    }
}
