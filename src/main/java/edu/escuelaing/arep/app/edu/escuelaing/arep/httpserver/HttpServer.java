package edu.escuelaing.arep.app.edu.escuelaing.arep.httpserver;

import java.net.*;
import java.io.*;

public class HttpServer {

    private static boolean isAlive = true;

    /**
     * Servidor de peticiones http.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(getPort());
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }

        while(isAlive()) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            String outputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Recibí: " + inputLine);
                if (!in.ready()) {
                    break;
                }
                if (inputLine.contains("GET")){
                    String[] typeData = inputLine.split(" ");
                    String data = typeData[1];
                    if(data.equals("/hello.html")){
                        doHello(out);
                    }else if(data.equals("/dogs.jpg") || data.equals("/dogs.JPG")){
                        doDogs(out);
                    }else if(data.contains("/cats.png") || data.contains("/cats.PNG")){
                        doCats(out);
                    }else{
                        notFound(out);
                    }

                }
            }

            /*
            outputLine = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/html\r\n"
                    + "\r\n"
                    + "<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<head>\n"
                    + "<meta charset=\"UTF-8\">\n"
                    + "<title>Title of the document</title>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "<h1>Mi propio mensaje</h1>\n"
                    + "</body>\n"
                    + "</html>\n";
            out.println(outputLine);
            out.close();
             */
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }

    /**
     * Nos dice si el servidor esta prendido o apagado.
     * @return boolean.
     */
    private static boolean isAlive() {
        return isAlive;
    }

    /**
     *  Nos permite cambiar el estado del servidor, de apagado a prendido, o al contrario.
     * @param alive
     */
    private static void setAlive(boolean alive) {
        isAlive = alive;

    }

    /**
     * html estático que está contenido en disco.
     * @param out
     */
    public static void doHello(PrintWriter out){
        String outputLine;
        outputLine = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Hello!!!</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>Very good days!</h1>\n"
                + "</body>\n"
                + "</html>\n";
        out.println(outputLine);
        out.close();
    }

    /**
     * html estático que nos devuelve una imagen de perros
     * @param out
     */
    public static void doDogs(PrintWriter out){
        String outputLine;
        outputLine = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Dogs!!</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<img src=\"https://www.happets.com/blog/wp-content/uploads/2019/08/ventajas-de-un-dispensador-de-comida-para-perros.jpg\" />\n"
                + "</body>\n"
                + "</html>\n";
        out.println(outputLine);
        out.close();
    }

    /**
     * html estático que nos devuelve una imagen de gatos.
     * @param out
     */
    public static void doCats(PrintWriter out){
        String outputLine;
        outputLine = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Title of the document</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<img src=\"https://www.pngkey.com/png/detail/909-9090660_adopt-cat-imagens-de-gatos-png.png\" />\n"
                + "</body>\n"
                + "</html>\n";
        out.println(outputLine);
        out.close();
    }

    /**
     * Método que nos retorna error en caso de no encontrar una petición en disco.
     * @param out
     */
    public static void notFound(PrintWriter out) {
        String outputLine;
        outputLine = "HTTP/1.1 404 not Found\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Error</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>Does not exist</h1>\n"
                + "</body>\n"
                + "</html>\n";
        out.println(outputLine);
        out.close();
    }

    /**
     * Método que nos devuelve el puerto por el que correrá localmente nuestro servicio
     * @return el puerto del servicio.
     */
    private static int getPort(){
        if(System.getenv("PORT") != null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 36000;
    }

}
