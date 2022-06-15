package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class URLReader {

    public static void main(String[] args) throws Exception {

        Scanner myObj = new Scanner(System.in);
        String url;
        System.out.println("Ingrese su url");
        url = myObj.nextLine();

        URL google = new URL(url);
        PrintWriter writer = new PrintWriter("resultado.html", "UTF-8");


        try (BufferedReader reader
                     = new BufferedReader(new InputStreamReader(google.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                writer.println(inputLine);
            }

        } catch (IOException x){
            System.err.println(x);
        }

        System.out.println("¡La pagina fue guardada!");






    }
}
