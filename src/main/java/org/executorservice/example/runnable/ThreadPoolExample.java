package org.executorservice.example.runnable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
    public static void main(String[] args) {
        /*
         * corePoolSize of Thread : 10 maxPoolSize of Thread : 100 ArrayBlockingQueue : fixed size 300
         */
        ExecutorService service = new ThreadPoolExecutor(10, 100, 120, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(300));
        try {
            for (int i = 0; i < 100; i++) {
                service.submit(new Task());
            }
        } catch (RejectedExecutionException exception) {
            // if task submitted and queue is full also all threads are busy it rejects the task with exception.
            System.out.println(" task rejected exceeded size of blocking queue" + exception.getMessage());
        }
    }

    static class Task implements Runnable {
        public void run() {
            System.out.println("Running Task : " + Thread.currentThread().getName());
        }
    }
}
