package edu.escuelaing.arep.app.edu.escuelaing.arep.ejercicio2;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class UrlReader {


    /**
     * Por medio de una url ingresada, creara y guardara un archivo html. en la carpeta raiz, AREP-lab3
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        System.out.print("Ingresa una url: ");
        Scanner input = new Scanner(System.in);
        String newUrl = input.nextLine();
        URL siteURL = new URL(newUrl);

        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(siteURL.openStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("resultado.html"));
            String inputLine = null;
            while ((inputLine = bufferedReader.readLine()) != null){
                bufferedWriter.write(inputLine);
            }
        }catch (IOException x){
            System.err.println(x);
        }
        System.out.print("Por favor revisa la carpeta AREP-lab3 el archivo resultado.html");
    }
}
