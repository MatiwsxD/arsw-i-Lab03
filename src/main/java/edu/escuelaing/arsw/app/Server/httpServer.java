package edu.escuelaing.arsw.app.Server;


import edu.escuelaing.arsw.app.Objects.genObject;
import edu.escuelaing.arsw.app.Objects.typeObject;
import edu.escuelaing.arsw.app.Type.ContentType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class httpServer {
    public void start() throws IOException {


        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(getPort());
        } catch (IOException e) {
            System.err.println("Could not listen on port: 36000.");
            System.exit(1);
        }
        boolean running = true;

        while (running) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            String ruta = "";

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                if (inputLine.contains("GET")) {
                    ruta = inputLine.split(" ")[1];
                }
                if (!in.ready()) {
                    break;
                }
            }
            ruta = ruta.substring(1);
            System.out.println(ruta);
            try {
                genObject obj = typeObject.build(ContentType.valueOf(ruta.split("\\.")[ruta.split("\\.").length - 1]),clientSocket);
                obj.createHttp(ruta);
                obj.sendResult();
                String outputLine = "HTTP/1.1 404 \r\n"
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
                        + "</html>\n" + inputLine;

            } catch (Exception ex) {
                String outputLine;
                outputLine = "HTTP/1.1 404 Not Found";
                PrintWriter out = new PrintWriter(
                        clientSocket.getOutputStream(), true);
                out.println(outputLine);
                out.close();
                clientSocket.close();
            }

        }
    }

    private int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 36000; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
}