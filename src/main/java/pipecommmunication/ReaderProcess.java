package pipecommmunication;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.*;
import java.util.Scanner;

//Напишете приложение на C++, C# или Java за pipe комуникация.
//Първия процес трябва да чете низ от клавиатура а втория да го отпечатва на екран,
// докато се срещне командата – end.
public class ReaderProcess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("READER: Waiting for data...");

        while (true) {
            String line = scanner.nextLine();

            if ("end".equalsIgnoreCase(line)) {
                System.out.println("READER: Terminating.");
                break;
            }
            System.out.println("READER Printed: " + line);
        }
    }
}
