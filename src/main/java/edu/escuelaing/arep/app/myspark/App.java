package edu.escuelaing.arep.app.myspark;

import static edu.escuelaing.arep.app.myspark.MySparkCreation.*;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {
        get("/hello", (req, resp) -> "Hello World");
    }

}
