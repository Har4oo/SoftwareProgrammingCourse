package serverclient;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        String myText = "Hello, this is line 1.\nThis is line 2 with a € symbol.";

        // The "try-with-resources" block auto-closes the writers.
        try (
                // 1. The raw byte stream (speaks bytes)
                FileOutputStream fileOut = new FileOutputStream("file.txt");

                // 2. The translator (speaks characters to bytes, using UTF-8)
                OutputStreamWriter osWriter = new OutputStreamWriter(fileOut, StandardCharsets.UTF_8);

                // 3. The efficient writer (speaks text, and buffers it)
                BufferedWriter writer = new BufferedWriter(osWriter)
        ) {
            writer.write(myText);
            writer.flush();
            System.out.println("Successfully wrote to file with UTF-8 encoding!");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
