package serverclient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//Напишете мрежово клиент/сървър на C++, C# или Java. Сървърът трябва да чете низ от клавиатура,
//a породената да го отпечатва на екран, докато се срещне командата – end.
public class Server {
    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("SERVER: Waiting for client on port " + port + "...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("SERVER: Client connected!");

            BufferedReader netReader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );
            String message;
            while ((message = netReader.readLine()) != null) {

                if ("end".equalsIgnoreCase(message)) {
                    System.out.println("SERVER: Client sent 'end'. Stopping.");
                    break;
                }

                System.out.println("SERVER received: " + message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
