package testConcurrent;

import java.util.concurrent.*;

public class ThreadPoolTest {

  public static void main(String args[]) throws Exception {
    Executor executor;
    ExecutorService executorService;
    executorService = Executors.newSingleThreadExecutor();
    executorService = Executors.newFixedThreadPool(2);
    executorService = Executors.newCachedThreadPool();
    executorService = Executors.newScheduledThreadPool(2);
    executorService.execute(new Runnable() {
      @Override
      public void run() {

      }
    });


    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 3, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(),
            null,
            new ThreadPoolExecutor.CallerRunsPolicy());
    threadPoolExecutor.execute(new Runnable() {
      @Override
      public void run() {

      }
    });

    threadPoolExecutor.shutdown();
    threadPoolExecutor.shutdownNow();
  }
}
