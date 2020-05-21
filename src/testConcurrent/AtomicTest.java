package testConcurrent;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicTest {

  public static void main(String args[]) {

    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.getAndIncrement();
    atomicInteger.incrementAndGet();
    atomicInteger.decrementAndGet();
    atomicInteger.addAndGet(2);
    System.out.println(atomicInteger);
  }
}
