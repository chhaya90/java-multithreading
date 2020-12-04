package org.executorservice.example.callable;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        Runnable tasks can be submitted or executed but to submit callable task that returns value can only be submitted
        */
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // returns the list of value from task that will be returned in future.
        // Future is place holder for value that will arrive in future based on how much time task takes to complete.
        Future<Integer> future = executorService.submit(new Task());

        //do some other operation.
        //after 1 sec you are calling.
        Integer result = future.get(); //blocking operation since  task is not yet completed.


    }


    static class Task implements Callable<Integer> {
        /*
         Runnable run() method cannot return anything its void method.To return value from task implement Callable
         call method that return Integer value.
         */
        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            return new Random().nextInt();
        }
    }
}
