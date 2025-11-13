package org.example.syncthreads;

import java.util.Scanner;

//Напишете приложение на C++, C# или Java за стартиране на
//синхронни нишки и изчакване на тяхното завършване.
//Главната нишка трябва да чете низ от клавиатура, а породената
//да го отпечатва на екран докато се срещне командата – end.

public class Main {
    public static void main(String[] args) {
        MessageBroker broker = new MessageBroker();

        Thread printerThread = new Thread(new Printer(broker));
        printerThread.start();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Start typing (type 'end' to quit):");

        while (true) {
            String input = scanner.nextLine();
            broker.put(input);

            if ("end".equals(input)) {
                break;
            }
        }

        scanner.close();
        System.out.println("Main thread finished.");
    }
}