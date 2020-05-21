package testConcurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

  public static void main(String args[]) throws Exception {

    FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
      @Override
      public String call() {
        return "Zma1";
      }
    });

    Thread thread1 = new Thread(futureTask);
    thread1.start();
    System.out.println(futureTask.get());

  }
}
