package testConcurrent;


import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// 生产者消费者写法1: await + signal
public class ProducerCosumer3 {

  volatile private static LinkedList<Integer> linkedList = new LinkedList<>();

  public static void main(String args[]) {

    ReentrantLock reentrantLock = new ReentrantLock();
    Condition condition1 = reentrantLock.newCondition();
    Condition condition2 = reentrantLock.newCondition();

    // 生产者
    new Thread(){
      @Override
      public void run() {
        reentrantLock.lock();
        try {
          for(int i=0; i<5; i++) {
            System.out.println("生产者: " + i);
            linkedList.add(i);
            condition2.signal();
            if(i != 4) condition1.await();
          }
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          reentrantLock.unlock();
        }
      }
    }.start();


    // 消费者
    new Thread(){
      @Override
      public void run() {
        reentrantLock.lock();
        try {
          for(int i=0; i<5; i++) {
            System.out.println("消费者: " + linkedList.pop());
            condition1.signal();
            if(i != 4) condition2.await();
          }
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          reentrantLock.unlock();
        }
      }
    }.start();
  }
}
