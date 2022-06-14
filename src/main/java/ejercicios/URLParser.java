package ejercicios;

import java.net.MalformedURLException;
import java.net.URL;

public class URLParser{
        public static void main(String[] args) {
            try {
                URL googleURL = new URL("http://www.google.com:80/anatomy-of-full-path-url-hostname-protocol-path-more/to/myfile.html?key=value1&key2=value2#domain-name");
                System.out.println("Protocol: " + googleURL.getProtocol());
                System.out.println("Host: " + googleURL.getHost());
                System.out.println("Port: " + googleURL.getPort());
                System.out.println("Authority: " + googleURL.getAuthority());
                System.out.println("Path: " + googleURL.getPath());
                System.out.println("Query: " + googleURL.getQuery());
                System.out.println("File: " + googleURL.getFile());
                System.out.println("Ref.: " + googleURL.getRef());
            } catch (MalformedURLException e) {
                e.printStackTrace();

            }

        }
}
