package org.executorservice.example.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableExample2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Future> futureList = new ArrayList<Future>(100);
        for (int i = 0; i < 100; i++) {
            //submit 100 task that returns 100 Future object as place holder which will have the value returned from task when its completed.
            Future<Integer> future = service.submit(new Task());
            //each Future object is added to list of Future object.
            futureList.add(future);
        }

        for (int i = 0; i < 100; i++) {
            Future<Integer> result = futureList.get(i);
            //get value from future object and do processing.If value is not there at this time in Future object Main thread goes to blocking state.
            //Once the Task is completed and value is returned to place holder main is unblocked and goes to runnable state.
            Integer number = result.get();
            // to avoid blocking state can wait for place holder to have result until specified time otherwise timeout and throw timeout exception.
            result.get(10, TimeUnit.SECONDS);

            /*
            cancel the task .If Task is not running in runnable state it is cancelled.If task is in running state depends on boolean value
             mayInterruptIfRunning True or False.
             */
            result.cancel(false);

            // returns true if task is cancelled.
            result.isCancelled();

            // returns true if task is completed successfully.
            result.isDone();

            System.out.println(" Result of future :" + i + " " + number);
        }
    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            return new Random().nextInt();
        }
    }
}
