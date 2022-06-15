package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MathServer {

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
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine, outputLine;
        double val;
        String operation ="cos";
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Mensaje: " + inputLine);
            if(inputLine.equals("fun:sin")){
                operation = "sin";
            }
            if(inputLine.equals("fun:tan")){
                operation = "tan";
            }
            else{
                val = Double.parseDouble(inputLine);
                if(operation.equals("cos")){
                    inputLine = Double.toString(Math.cos(val));
                }
                else if (operation.equals("sin")) {
                    inputLine = Double.toString(Math.sin(val));
                }
                else if (operation.equals("tan")) {
                    inputLine = Double.toString(Math.tan(val));
                }

            }

            outputLine = "Respuesta: " + inputLine;
            out.println(outputLine);
            if (outputLine.equals("Respuesta: Bye."))
                break;
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
