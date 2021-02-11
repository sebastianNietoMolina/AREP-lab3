package edu.escuelaing.arep.app.edu.escuelaing.arep.ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSquare {

    /**
     * Este cliente envia una secuencia de 20 números para que el servidor calcule su potencia cuadrada.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        int[] clientData = {15, 16, 1632, 247, 346, 1346, 136 ,68, 9875 ,356, 2346, 784 ,246 ,1345 ,7, 53,8 ,94, 81973,29};

        try {

            echoSocket = new Socket("127.0.0.1", 35000);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

        }catch (UnknownHostException e) {

            System.err.println("Don’t know about host!.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn’t get I/O for " + "the connection to: localhost.");
            System.exit(1);
        }
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;

        /*
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println("echo: " + in.readLine());
        }
         */

        for(int i: clientData){
            out.println(i);
            String res = in.readLine();
            System.out.println(i + "^2 = " + res);
        }

        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}
