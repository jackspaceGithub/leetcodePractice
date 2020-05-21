package testConcurrent;

import java.util.concurrent.LinkedBlockingQueue;


// 生产者消费者写法2
public class ProducerCosumerBlockingQueueTest {

  // 阻塞队列实战
  public static void main(String args[]) throws Exception {
    In in = new In();

    for(int i2=0; i2 < 2; i2++) {
      new Thread() {
        @Override
        public void run() {
          try {
            for (int i = 0; i < 5; i++) {
              in.cosumer();
            }
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }.start();
    }


    new Thread() {
      @Override
      public void run() {
        try {
          for (int i = 0; i < 5; i++) {
            in.produce(i);
            if(i == 2) {
              Thread.sleep(2);
            }
          }
        } catch (Exception e) {
          e.printStackTrace();
        }

      }
    }.start();

  }

}
