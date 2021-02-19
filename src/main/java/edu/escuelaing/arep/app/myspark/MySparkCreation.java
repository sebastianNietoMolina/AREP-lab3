package edu.escuelaing.arep.app.myspark;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.BiFunction;

public class MySparkCreation {


    public static void get(String path, BiFunction<HttpRequest, HttpResponse, String> sup){
        MySparkCreationServer mscserver = MySparkCreationServer.getInstance();
        mscserver.get(path, sup);
        mscserver.startServer();
    }

}
