package testConcurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

  private static int x = 0;

  public static void main(String args[]) throws Exception {

    ReentrantLock reentrantLock = new ReentrantLock();

    for(int i=0; i < 5; i++) {
      new Thread(){
        public void run() {
          try{
            Thread.sleep(1);
            reentrantLock.lock();
            reentrantLock.tryLock(2L, TimeUnit.SECONDS);
            x++;
          } catch (Exception e) {
            e.printStackTrace();
          } finally {
            reentrantLock.unlock();
          }
        }

      }.start();
    }

    Thread.sleep(100);
    System.out.println(x);
  }
}
