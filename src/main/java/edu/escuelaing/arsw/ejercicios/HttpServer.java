package ejercicios;

import java.net.*;
import java.io.*;

public class HttpServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(36000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
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


            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine;
            boolean flag = true;
            String path = null;
            while ((inputLine = in.readLine()) != null) {
                if(flag){
                    path = inputLine.split(" ")[1];
                    flag = false;
                }
                System.out.println("Received: " + inputLine);
                if (!in.ready()) {
                    break;
                }
            }
            System.out.println(path);

            outputLine = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/html\r\n"
                    + "\r\n"
                    + "<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<meta charset=\"UTF-8\">"
                    + "<title>Title of the document</title>\n" + "</head>"
                    + "<body>"
                    + "My Web Site</br>"
                    + "<img src='https://escuelaing.s3.amazonaws.com/production/images/FOTO11.width-500.jpg?AWSAccessKeyId=AKIAWFY3NGTFBJGCIWME&Signature=QlieSOHojvOdCn%2FClIcnvDvf6yg%3D&Expires=1657633996'>"
                    + "</body>"
                    + "</html>" + inputLine;

            out.println(outputLine);

            out.close();

            in.close();

            clientSocket.close();
        }
            serverSocket.close();
        }

}