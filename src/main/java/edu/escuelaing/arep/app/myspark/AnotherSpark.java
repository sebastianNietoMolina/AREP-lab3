package edu.escuelaing.arep.app.myspark;

import edu.escuelaing.arep.app.httpserver.HttpServer;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class AnotherSpark {

    Map<String, BiFunction<HttpRequest, HttpResponse, String>> route = new HashMap<String, BiFunction<HttpRequest, HttpResponse, String>>();
    HttpServer httpServer = new HttpServer();

    /**
     * Constructor de la clase MySparkCreation, nos permite colocar por defecto el path /App.
     */
    public AnotherSpark(){
        httpServer.registerProessor("/App", this);
    }

    /**
     * Agrega todas las rutas antes de iniciar el servidor http.
     * @param path representa el token.
     * @param sup la expresion lambda que vamos a usar.
     */
    public void get(String path, BiFunction<HttpRequest, HttpResponse, String> sup)  {
        route.put(path, sup);
    }

    /**
     * Inicializa el servidor https.
     */
    public void startServer()   {
        try {
            httpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifica que la ruta a buscar si exista en nuestro arreglo de rutas.
     * @param path de la ruta que estamos buscando
     * @param req valor lambda
     * @param resp valor lambda
     * @return html diciendo si el valor encontrado es correcto o no, se mostrara en pantalla.
     */
    public String handle(String path, HttpRequest req, HttpResponse resp){
        if(route.containsKey(path)){
            return httpOk() + route.get(path).apply(req, resp);
        }
        return httpNotOk() + "Error";
    }

    private String httpNotOk() {
        return "HTTP/1.1 404 not Found\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Error</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>There is an error</h1>\n"
                + "</body>\n"
                + "</html>\n";
    }

    private String httpOk() {
        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n";
    }

}
