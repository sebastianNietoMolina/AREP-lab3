package edu.escuelaing.arep.app.ejercicio1;

import java.net.URL;

public class UrlComponents {

    /**
     * Retorna los componentes que puede encontrar en una URL, en este caso tome una real.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://enlacocina.telemesa.es:25000/actualidad/los-mejores-blogs-cocina?value=carreta/#Gastronomiaycia");
        System.out.println("Protol: "+getProtocol(url));
        System.out.println("Authority: "+getAuthority(url));
        System.out.println("Host: "+getHost(url));
        System.out.println("Port: "+getPort(url));
        System.out.println("Path: "+getPath(url));
        System.out.println("Query: "+getQuery(url));
        System.out.println("File: "+getFile(url));
        System.out.println("Ref:" +getRef(url));
    }

    /**
     * Separa el protocolo de la url.
     * @param url
     * @return El protocolo usado.
     */
    public static String getProtocol(URL url){
        return url.getProtocol();
    }

    /**
     * Separa la autoridad de la url
     * @param url
     * @return La autoridad con la que se creo la página.
     */
    public static String getAuthority(URL url){
        return url.getAuthority();
    }

    /**
     * Separa el host de la url
     * @param url
     * @return el host
     */
    public static String getHost(URL url){
        return url.getHost();
    }

    /**
     * Separa el puerto de la url
     * @param url
     * @return el puerto
     */
    public static int getPort(URL url){
        return url.getPort();
    }

    /**
     * Separa el path de la url
     * @param url
     * @return el path.
     */
    public static String getPath(URL url){
        return url.getPath();
    }

    /**
     * Separa las query que hay.
     * @param url
     * @return las query
     */
    public static String getQuery(URL url){
        return url.getQuery();
    }

    /**
     * Separa los file que hay
     * @param url
     * @return los file
     */
    public static String getFile(URL url){
        return url.getFile();
    }

    /**
     * Separa la referencia de la url
     * @param url
     * @return las referencias.
     */
    public static String getRef(URL url){
        return url.getRef();
    }

}
