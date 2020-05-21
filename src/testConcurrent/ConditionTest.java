package testConcurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
  static ReentrantLock lock = new ReentrantLock();

  public static void main(String args[]) {

    // 基本用法实例
//      Condition condition = lock.newCondition();
//
//      new Thread(() -> {
//        lock.lock();
//        try {
//          System.out.println("线程一加锁成功");
//          System.out.println("线程一执行await被挂起");
//          condition.await();
//          System.out.println("线程一被唤醒成功");
//        } catch (Exception e) {
//          e.printStackTrace();
//        } finally {
//          lock.unlock();
//          System.out.println("线程一释放锁成功");
//        }
//      }).start();
//
//      new Thread(() -> {
//        lock.lock();
//        try {
//          System.out.println("线程二加锁成功");
//          condition.signal();
//          System.out.println("线程二唤醒线程一");
//        } finally {
//          lock.unlock();
//          System.out.println("线程二释放锁成功");
//        }
//      }).start();

      // 精确唤醒某个线程，notify无法做到
      Condition condition1 = lock.newCondition();
      Condition condition2 = lock.newCondition();

      new Thread(){
        public void run() {
          lock.lock();
          try {
            System.out.println("线程1 run，准备挂起");
            condition1.await();
            System.out.println("线程1 复活");
          } catch (InterruptedException i) {
            i.printStackTrace();
          } finally {
            lock.unlock();
          }
        }
      }.start();

      new Thread(){
        public void run() {
          lock.lock();
          try {
            System.out.println("线程2 run，准备挂起");
            condition2.await();
            System.out.println("线程2 复活");
          } catch (InterruptedException i) {
            i.printStackTrace();
          } finally {
            lock.unlock();
          }
        }
      }.start();

      new Thread(){
        public void run() {
          lock.lock();
          try {
            System.out.println("线程3叫 线程1 醒来");
            condition1.signal();
            System.out.println("线程3叫 线程2 醒来");
            condition2.signal();
          } finally {
            lock.unlock();
          }
        }
      }.start();

    }

}
