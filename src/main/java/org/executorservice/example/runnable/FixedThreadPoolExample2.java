package org.executorservice.example.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample2 {

    public static void main(String[] args) {
        // one java thread - 1 OS thread cpu intensive operation .
        // CPU with 4 cores can run only 4 thread at a time.so having too many
        // thread is not advisable for CPU intensive operation.

        int core = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of CPU core :" + core);

        ExecutorService service = Executors.newFixedThreadPool(core);
        for (int i = 0; i < 10; i++) {
            service.submit(new Task());
        }

         // I/O Tasks pool size can be higher.
    }

    static class Task implements Runnable {
        public void run() {
            System.out.println("Running Task :"+ Thread.currentThread().getName());
        }
    }
}
