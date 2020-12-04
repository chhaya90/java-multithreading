package org.executorservice.example.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPool {
    /*
     * Same as Fixed Thread pool just there is only thread that execute the task one after the other after fetching them from blocking Queue. If
     * thread is killed during the process creates new Thread.This ensures that tasks are completed in sequence Task_2 starts only when Task_1 is
     * completed.
     *
     *  corePoolSize :  1
     *  maxCorePoolSize: 1
     *  keepAliveTime: 0 Sec
     */
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        //submit the task
        for (int i = 0; i < 10; i++) {
            service.submit(new FixedThreadPoolExample2.Task());
        }
        System.out.println("Running Main : " + Thread.currentThread().getName());
    }

    static class Task implements Runnable {
        public void run() {
            System.out.println(" Running Task : " + Thread.currentThread().getName());
        }
    }
}
