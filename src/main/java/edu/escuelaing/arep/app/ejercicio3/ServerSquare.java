package edu.escuelaing.arep.app.ejercicio3;

import java.net.*;
import java.io.*;

public class ServerSquare {

    /**
     * Calcula la potencia al cuadrado de cada valor enviado por el cliente.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println("Mensaje: " + inputLine);
            outputLine = "Respuesta: " +  inputLine;
            if (outputLine.equals("Respuesta: Bye.")){
                break;
            }
            int newNum = Integer.parseInt(inputLine);
            outputLine = "Respuesta: " +  Math.pow(newNum,2);
            out.println(outputLine);

        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
