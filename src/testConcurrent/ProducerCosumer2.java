package testConcurrent;

import java.util.LinkedList;

// 生产者消费者写法1: notify + wait
public class ProducerCosumer2 {

  volatile static LinkedList<Integer> linkedList = new LinkedList<>();

  public static void main(String args[]) {

    // 生产者
    new Thread(){
      @Override
      public void run() {
        try {
          for (int i=0; i < 5; i++) {
            synchronized (linkedList) {
              System.out.println(Thread.currentThread().getName() + "生产: " + i);
              linkedList.add(i);
              linkedList.notify();
              if(i != 4) linkedList.wait();
            }
          }
        } catch (Exception e) {
          e.printStackTrace();
        }

      }
    }.start();

    // 消费者
    new Thread(){
      @Override
      public void run() {
        try {
          for (int i=0; i < 5; i++) {
            synchronized (linkedList) {
              System.out.println(Thread.currentThread().getName() + "消费: " + linkedList.poll());
              linkedList.notify();
              if(i != 4) linkedList.wait();
            }
          }
        } catch (Exception e) {
          e.printStackTrace();
        }

      }
    }.start();

  }
}
