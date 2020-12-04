package org.executorservice.example.runnable;

public class ThreadExample2 {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            // 5 new threads are created. 
            Thread thread = new Thread(new Task());
            // starts the thread cannot start the same thread once started IllegalStateException. 
            thread.start();
        }
        System.out.println(" Main Thread Running : " + Thread.currentThread().getName());

    }

    static class Task implements Runnable {
        public void run() {
            System.out.println(" Running Task : " + Thread.currentThread().getName());
        }
    }

}
