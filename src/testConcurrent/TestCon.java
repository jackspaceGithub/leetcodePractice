package testConcurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestCon {

  public static void main(String args[]) throws Exception {

    Lock lock = new ReentrantLock();
    lock.lock();
  }
}
