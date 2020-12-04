package org.executorservice.example.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    /*
     * Here you dont have fixed size thread in pool.Synchronous queue holds one task at a time. search for thread that is free if not create new
     * thread add it to pool and assign task to it. If thread is Idle for more than 60s no task to execute then kill the thread.
     *  corePoolSize :  1.
     *  maxCorePoolSize: Integer.MAX_VALUE.
     *  keepAliveTime: 60 Sec
     *  synchronousQueue data structure.
     */
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            service.submit(new Task());
        }
        System.out.println("Running Main" + Thread.currentThread().getName());
    }

    static class Task implements Runnable {
        public void run() {
            System.out.println("Running Task :" + Thread.currentThread().getName());
        }
    }
}
