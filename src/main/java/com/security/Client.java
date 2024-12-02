package com.security;

import javax.net.ssl.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception {
        System.setProperty("javax.net.ssl.trustStore", "ssl/clientTruststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "passserver123");

        SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socket = (SSLSocket) ssf.createSocket("localhost", 8080);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println("Hello, server!");
        System.out.println("Server says: " + in.readLine());

        socket.close();
    }
}
