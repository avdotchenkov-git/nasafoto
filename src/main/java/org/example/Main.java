package org.example;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String url = "https://api.nasa.gov/planetary/apod?api_key=hTmrl0x0OiT2SMI3lzLRgqb4XrpkVgLlxNw9uEO6";

        CloseableHttpClient client = HttpClients.createDefault();

        HttpGet request = new HttpGet(url);
        try {
            client.execute(request);
            CloseableHttpResponse response = client.execute(request);

            Scanner scanner = new Scanner(response.getEntity().getContent());
            System.out.println(scanner.nextLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}