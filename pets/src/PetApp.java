import main.java.com.kreitek.pets.BadCommandException;
import main.java.com.kreitek.pets.Controller;
import main.java.com.kreitek.pets.controllers.CatController;
import main.java.com.kreitek.pets.controllers.ControllerFactory;
import main.java.com.kreitek.pets.controllers.DogController;


import java.util.Scanner;

import main.java.com.kreitek.pets.infraestructure.Logger;

public class PetApp {

    //Logger declaration
    static int counter;

    public static void main (String[] args) {
        ControllerFactory controllerFactory = new ControllerFactory();
        boolean end = false;
        Logger logger = Logger.getInstance(counter);
 
        logger.debug("[debug]"+"["+ counter +"]" + "Pet app has been initiated");
        while (!end) {
            String command = waitForNewCommand();
            String[] commandArgs = command.split(":");
            try {
                String response = "";
                switch (commandArgs[0]) {
                    case "end":
                        end = true;
                        break;
                    case "get":
                        String param = getGetParam(commandArgs);
                        switch (param) {
                            case "dog":
                                Controller dogController = controllerFactory.getDogController();
                                response = dogController.executeGet(logger);
                                break;
                            case "cat":
                                Controller catController = controllerFactory.getCatController();
                                response = catController.executeGet(logger);
                                break;
                            default:
                                throw new BadCommandException();
                        }
                        System.out.println(response);
                        break;
                    case "put":
                        String[] params = getPutParams(commandArgs);
                        switch (params[0]) {
                            case "dog":
                                Controller dogController =  new DogController(logger);
                                response = dogController.executePut(params[1], params[2], params[3]);
                                break;
                            case "cat":
                                Controller catController = new CatController(logger);
                                response = catController.executePut(params[1], params[2], params[3]);
                                break;
                            default:
                                throw new BadCommandException();
                        }
                        System.out.println(response);
                }
            } catch (BadCommandException e) {
                System.out.println("Bad command error");
            }
        }
        counter = logger.counter;
        System.out.println("[debug]"+"["+ counter +"]" +"Pet app has been ended");
    }

    private static String getGetParam(String[] commandArgs) throws BadCommandException {
        if (commandArgs.length == 2) {
            return commandArgs[1];
        } else {
            throw new BadCommandException();
        }
    }

    private static String[] getPutParams(String[] commandArgs) throws BadCommandException {
        if (commandArgs.length <= 1) {
            throw new BadCommandException();
        }
        String[] parameters = commandArgs[1].split(";");
        if (parameters.length < 4) {
            throw new BadCommandException();
        }
        return parameters;
    }

    private static String waitForNewCommand() {
        System.out.println("Enter a command : ");
        Scanner scanner = new Scanner(System. in);
        return scanner. nextLine();
    }


}
