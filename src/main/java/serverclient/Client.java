package serverclient;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(hostname, port);
             OutputStreamWriter osWriter = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
             BufferedWriter netWriter = new BufferedWriter(osWriter);
             Scanner keyboard = new Scanner(System.in)) {

            System.out.println("CLIENT: Connected! Type messages (type 'end' to quit):");

            while (true) {
                System.out.print("> ");
                String input = keyboard.nextLine();

                netWriter.write(input);
                netWriter.newLine();
                netWriter.flush();

                if ("end".equalsIgnoreCase(input)) {
                    System.out.println("CLIENT: Shutting down.");
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("CLIENT: Error connecting. Is the server running?");
        }
    }
}
