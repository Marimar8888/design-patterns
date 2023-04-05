package main.java.com.kreitek.pets.infraestructure;

import main.java.com.kreitek.pets.LoggerController;

public class Logger implements LoggerController {

    public  static int counter=1;
    private void Logger(int counter){
        this.counter=counter;
    }
    @Override
    public void debug(String message) {
        this.counter++;
        System.out.println(message);

    }

}
