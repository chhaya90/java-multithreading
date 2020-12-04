package org.executorservice.example.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {
    /*
     corePoolSize :  same as constructor arg.
     maxCorePoolSize: same as constructor arg.
     keepAliveTime:  0 sec (no threads are killed)
     LinkedBlockingQueue : can add unlimited tasks.
     */
    public static void main(String[] args) {
        // upfront create a fixed size thread pool.
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //submit the tasks to Queue(LinkedBlockingQueue) .These tasks are placed
        // in blocking queue(since all thread try to access the queue .thread-safe operation) and every time fetched and processed.
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Task());
        }
        System.out.println("Running Main : " + Thread.currentThread().getName());
    }

    static class Task implements Runnable {
        public void run() {
            System.out.println(" Running Task : " + Thread.currentThread().getName());
        }
    }
}
