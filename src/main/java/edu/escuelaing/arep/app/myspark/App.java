package edu.escuelaing.arep.app.myspark;

/**
 * Hello world!
 *
 */
public class App {

    /**
     * main, clase ejectura para comenzar el programa.
     * @param args
     */
    public static void main( String[] args ) {
        AnotherSpark anotherSpark = new AnotherSpark();
        anotherSpark.get("/hello2", (req, resp) -> "Hello World2");
        anotherSpark.get("/hello", (req, resp) -> "Hello World");
        anotherSpark.startServer();
    }

}
