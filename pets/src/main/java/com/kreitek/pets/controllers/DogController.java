package main.java.com.kreitek.pets.controllers;

import main.java.com.kreitek.pets.Controller;
import main.java.com.kreitek.pets.domain.Dog;

import main.java.com.kreitek.pets.infraestructure.bd.DbService;
import main.java.com.kreitek.pets.infraestructure.Logger;

import java.util.List;

public class DogController implements Controller {
    //Logger declaration
    private static Logger logger;
    int counter;
    //Constructor recibiendo la instancia Logger
    public DogController(Logger logger){
        this.logger = logger;
    }
    public String executePut(String petName, String ownerName, String telephone) {
        counter = logger.counter;
        logger.debug("[debug]"+"["+ counter +"]" + petName + "," + ownerName + "," + telephone);
        Dog dog = new Dog(petName, ownerName, telephone);
        DbService dbService = DbService.getInstance();
        dbService.addNewDog(dog);
        return "New dog has been added";
    }

    @Override
    public String executeGet(Logger logger) {
        counter = logger.counter;
        logger.debug("[debug]"+"["+ counter +"]" + "DogController.executeGet DOGS");
        DbService dbService = DbService.getInstance();
        List<Dog> dogs = dbService.getDogs();
        String response = "";
        for (Dog dog:dogs) {
            response += dog.toString() + "\r\n";
        }
        return response;
    }
}
