package main.java.com.kreitek.pets.controllers;

import main.java.com.kreitek.pets.Controller;
import main.java.com.kreitek.pets.domain.Cat;

import main.java.com.kreitek.pets.infraestructure.bd.DbService;
import main.java.com.kreitek.pets.infraestructure.Logger;

import java.util.List;

public class CatController implements Controller {
    //Logger declaration

    static int counter;
    static Logger logger = Logger.getInstance(counter);

    public CatController(Logger logger){
        this.logger = logger;
    }


    @Override
    public String executePut(String petName, String ownerName, String telephone) {
        counter = logger.counter;
        logger.debug("[debug]"+"["+ counter +"]" +"CatController.executePut " + petName + "," + ownerName + "," + telephone);
        Cat cat = new Cat(petName, ownerName, telephone);
        DbService dbService = DbService.getInstance();
        dbService.addNewCat(cat);
        return "New cat has been added";
    }

    @Override
    public String executeGet(Logger logger) {
        counter = logger.counter;
        logger.debug("[debug]"+"["+ counter +"]" +"CatController.executeGet CATS");
        DbService dbService = DbService.getInstance();
        List<Cat> cats = dbService.getCats();
        String response = "";
        for (Cat cat:cats) {
            response += cat.toString() + "\r\n";
        }
        return response;
    }
}
