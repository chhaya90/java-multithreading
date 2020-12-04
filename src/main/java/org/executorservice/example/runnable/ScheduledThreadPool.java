package org.executorservice.example.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
 /*
  given some fixed size of thread pool. Uses delay queue to store all submitted task.task might not be sequential.
  Tasks are scheduled triggered at fixed rate for fixed delay.Creates more thread if required.
  */
 public static void main(String[] args) {
     /*
      *  corePoolSize :  constructor arg.
      *  maxCorePoolSize: Integer.MAX_VALUE.
      *  keepAliveTime: 60 Sec
      *  DelayedWorkQueue : Time based execution of task.
      */
     ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

     //schedule task to run after initial delay of 10 seconds.
     service.schedule(new Task(),10, TimeUnit.SECONDS);

     //schedule task to run first time after initial delay of 15 seconds and after that after every 10 seconds.
     service.scheduleAtFixedRate(new Task(),15,10,TimeUnit.SECONDS);

     //schedule task to run first time after initial delay of 15 seconds and wait for task to complete and
     // trigger another task after completion after delay of  10 seconds.
     service.scheduleWithFixedDelay(new Task(),15,10,TimeUnit.SECONDS);
 }
    static class Task implements Runnable{

        public void run() {

        }
    }
}
