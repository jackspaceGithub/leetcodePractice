package testConcurrent;

import java.util.concurrent.LinkedBlockingQueue;

public class In {

  volatile private LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<Integer>(10);

  // 生产
  public void produce(int i) {
    System.out.println("生产数字: " + i);
    linkedBlockingQueue.add(i);
  }

  // 消费
  public void cosumer() throws Exception {
    System.out.println(Thread.currentThread().getName() + " 消费数字: " + linkedBlockingQueue.take());
//    Thread.sleep(1);
  }
}
