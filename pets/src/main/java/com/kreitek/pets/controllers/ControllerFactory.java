package main.java.com.kreitek.pets.controllers;

import main.java.com.kreitek.pets.Controller;
import main.java.com.kreitek.pets.infraestructure.Logger;


public class ControllerFactory {
    private static Logger logger;
    public Controller getCatController() {
        return  new CatController(logger);
    }

    public Controller getDogController() {
        return  new DogController(logger);
    }
}
