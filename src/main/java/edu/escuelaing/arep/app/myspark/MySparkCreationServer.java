package edu.escuelaing.arep.app.myspark;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import edu.escuelaing.arep.app.httpserver.HttpServer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class MySparkCreationServer {

    Map<String, BiFunction<HttpRequest, HttpResponse, String>> route = new HashMap<String, BiFunction<HttpRequest, HttpResponse, String>>();
    HttpServer httpServer = new HttpServer();

    private static MySparkCreationServer _instance = new MySparkCreationServer();

    private MySparkCreationServer(){
        httpServer.registerProessor("/App", this);
    }

    public static MySparkCreationServer getInstance(){
        return _instance;
    }

    public void get(String path, BiFunction<HttpRequest, HttpResponse, String> sup){
        route.put(path, sup);
    }

    public void startServer()   {
        try {
            httpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String handle(String path, HttpRequest req, HttpResponse resp){
        if(route.containsKey(path)){
            return httpOkHeader() + route.get(path).apply(req, resp);
        }
        return httpNotOkHeader() + "Error";
    }

    private String httpNotOkHeader() {
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

    private String httpOkHeader() {
        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n";
    }
}
