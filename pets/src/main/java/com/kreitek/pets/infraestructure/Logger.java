package main.java.com.kreitek.pets.infraestructure;

public class Logger {
    private static volatile Logger instance;
    public  static int counter=1;

    public Logger(int counter) {
        this.counter = counter;
    }

    public static Logger getInstance(int counter){
        Logger result = instance;
        if(result !=null){
            return result;
        }
        synchronized (Logger.class){
            if(instance == null){
                instance = new Logger(counter);
            }
            return instance;
        }
    }
    public void debug(String message) {
        this.counter++;
        System.out.println(message);

    }
    public int getCounter(){
        return counter;
    }

}
