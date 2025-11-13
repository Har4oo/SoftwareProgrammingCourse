package pipecommmunication;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class WriterProcess {
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);

        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", "target/classes", "pipecommmunication.ReaderProcess");

            pb.inheritIO();

            System.out.println("WRITER: Starting the ReaderProcess...");
            Process childProcess = pb.start();

            BufferedWriter childInput = new BufferedWriter(
                    new OutputStreamWriter(childProcess.getOutputStream())
            );

            System.out.println("WRITER: Enter messages (type 'end' to quit):");

            while (true) {
                String line = keyboard.next();

                childInput.write(line);
                childInput.newLine();

                if ("end".equalsIgnoreCase(line)) {
                    System.out.println("WRITER: Sending 'end' and shutting down.");
                    break;
                }
            }

            int exitCode = childProcess.waitFor();
            System.out.println("WRITER: Child process exited with code " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
