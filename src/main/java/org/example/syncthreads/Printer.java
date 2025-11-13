package org.example.syncthreads;

class Printer implements Runnable {
    private final MessageBroker broker;

    public Printer(MessageBroker broker) {
        this.broker = broker;
    }

    @Override
    public void run() {
        while (true) {
            String received = broker.getMessage();

            if ("end".equals(received)) {
                System.out.println("Printer: Terminating...");
                break;
            }

            System.out.println("Printed by Thread-2: " + received);
        }
    }
}