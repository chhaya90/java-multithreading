package org.executorservice.example.runnable;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShutdownExample {
    public static void main(String[] args) throws InterruptedException {
        /*
         * The difference is that execute simply starts the task without any further ado, whereas submit returns a Future object to manage the task.
         * You can do the following things with the Future object: Cancel the task prematurely, with the cancel method.
         */
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new FixedThreadPoolExample.Task());
        }
        // initiate shutdown dont accept anymore task after this but completes execution of all task in queue and also currently running.
        executorService.shutdown();

        // throw RejectedExecutionException as shutdown is initiated cant accept more task.
        //executorService.execute(new Task());

        // Returns True since shutdown has begun.
        System.out.println(executorService.isShutdown());

        // Returns True if all tasks are completed including queued task.
        System.out.println(executorService.isTerminated());

        //block until submitted tasks are completed or if timeout occurs.
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        //Return list of tasks that was queued is not completed .Complete all tasks that are currently running.
        List<Runnable> notCompletedTasks = executorService.shutdownNow();

        System.out.println("Running Main : " + Thread.currentThread().getName());
    }

    static class Task implements Runnable {
        public void run() {
            System.out.println(" Running Task : " + Thread.currentThread().getName());
        }
    }
}
