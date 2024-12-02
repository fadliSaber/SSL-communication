package com.security;

import javax.net.ssl.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws Exception {
        System.setProperty("javax.net.ssl.keyStore", "ssl/serverkey.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "stpass123");

        SSLServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket serverSocket = (SSLServerSocket) ssf.createServerSocket(9999);

        System.out.println("Secure server started...");
        while (true) {
            SSLSocket socket = (SSLSocket) serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Hello, secure world!");
            System.out.println("Client says: " + in.readLine());

            socket.close();
        }
    }
}
