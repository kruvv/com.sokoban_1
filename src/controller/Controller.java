package controller;


import model.Direction;
import model.GameObjects;
import model.Model;

import view.View;

import java.io.IOException;
import java.util.logging.Logger;


public class Controller implements EventListener {

   // private static final Logger log = Logger.getLogger(String.valueOf(Controller.class));

    private View view;
    private Model model;

    public Controller() throws IOException {
        this.view = new View (this);
        this.model = new Model();

        view.init();
       // log.info("Вызвана инициация контроллера");
        view.setEventListener(this);
        model.restart();
        model.setEventListener(this);
    }

    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();


    }

    public GameObjects getGameObjects() {
        return model.getGameObjects();
    }

    @Override
    public void move(Direction direction) {
        model.move(direction);
        view.update();

    }

    @Override
    public void restart() {
        model.restart();
        view.update();
    }

    @Override
    public void startNextLevel() {
        model.startNextLevel();
        view.update();
    }

    @Override
    public void levelCompleted(int level) {
        view.completed(level);
    }

}
