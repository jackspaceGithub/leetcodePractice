package testConcurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

  public static void main(String args[]) throws ExecutionException, InterruptedException {
    FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
      @Override
      public String call() throws Exception {
        throw new Exception("fuck");
//        return null;
      }
    });

    new Thread(futureTask).start();
    futureTask.get();
  }
}
