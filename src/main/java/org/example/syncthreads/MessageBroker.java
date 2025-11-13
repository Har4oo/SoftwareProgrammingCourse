package org.example.syncthreads;

public class MessageBroker {
    private String message;
    private boolean hasMessage = false;

    public synchronized void put(String message) {
        while (hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.message = message;
        this.hasMessage = true;
        notify();
    }
    public synchronized String getMessage() {
        while (!hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.hasMessage = false;
        notify();
        return this.message;
    }
}
