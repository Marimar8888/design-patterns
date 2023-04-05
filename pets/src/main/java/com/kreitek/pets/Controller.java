package main.java.com.kreitek.pets;

import main.java.com.kreitek.pets.infraestructure.Logger;

public interface Controller {

    String executePut(String petName, String ownerName, String telephone);
    String executeGet(Logger logger);
}
