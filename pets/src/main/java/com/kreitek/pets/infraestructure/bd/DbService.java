package main.java.com.kreitek.pets.infraestructure.bd;

import main.java.com.kreitek.pets.domain.Cat;
import main.java.com.kreitek.pets.domain.Dog;
import main.java.com.kreitek.pets.infraestructure.Logger;

import java.util.ArrayList;
import java.util.List;

public class DbService {
    private static volatile DbService instance = null;
    static int counter;
    static Logger logger = Logger.getInstance(counter);
    private List<Cat> cats = new ArrayList<>();
    private List<Dog> dogs = new ArrayList<>();

    private DbService(Logger logger) {
        this.logger=logger;
        if (instance != null) {
            throw new RuntimeException("Usage getInstance() method to create");
        }
    }

    public static DbService getInstance() {
        if (instance == null) {
            synchronized(DbService.class) {
                if (instance == null) {
                    instance = new DbService(logger);
                }
            }
        }
        return instance;
    }

    public void addNewDog(Dog dog) {
        dogs.add(dog);
        counter = logger.counter;
        logger.debug("[debug]"+"["+counter+"]" +"BdService.Dog added");
    }
    public void addNewCat(Cat cat) {
        cats.add(cat);
        counter = logger.counter;
        logger.debug("[debug]"+"["+ counter +"]" +"BdService.Cat added");
    }

    public List<Cat> getCats() {
        counter = logger.counter;
        logger.debug("[debug]"+"["+ counter +"]" +"BdService.Get " + cats.size() + " cats");
        return new ArrayList<>(cats);
    }

    public List<Dog> getDogs() {
        counter = logger.counter;
        logger.debug("[debug]"+"["+ counter +"]" +"BdService.Get " + dogs.size() + " dogs");
        return new ArrayList<>(dogs);
    }
}
