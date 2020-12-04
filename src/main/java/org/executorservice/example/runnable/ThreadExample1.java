package org.executorservice.example.runnable;

public class ThreadExample1 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        //starts new thread calls run method from Task
        thread.start();
        System.out.println(" Running Main :  " + Thread.currentThread().getName());
    }

    static class Task implements Runnable {
        public void run() {
            System.out.println("Running Task : " + Thread.currentThread().getName());
        }
    }
}
