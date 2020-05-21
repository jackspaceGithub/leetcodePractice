package testConcurrent;

/**
 * 搞清楚wait
 */
public class WaitTest {

  public static void main(String[] args) throws Exception {
    final Integer x = 9;
    Thread thread1 = new Thread() {
      @Override
      public void run() {
        try {
          synchronized (x){
            System.out.println("1准备进入等待队列");
            // 接受中断信号并清除中断信号，第一次返回true，后面是false
            System.out.println(Thread.interrupted() ? "true1" : "false1");
            x.wait();
            System.out.println("1");
          }
        } catch (Exception e) {
          System.out.println("我错了1");
          e.printStackTrace();
        }
      }
    };

    Thread thread2 = new Thread() {
      @Override
      public void run() {
        try {
          synchronized (x){
            System.out.println("2准备进入等待队列");
            x.wait();
            System.out.println("2");
          }
        } catch (Exception e) {
          System.out.println("我错了2");
          e.printStackTrace();
        }
      }
    };

    thread1.start();
    // 中断线程
    thread1.interrupt();
    // 强制终止线程
//    thread1.stop();
    // 只是用来判断当前线程是否被中断了
//    System.out.println(Thread.interrupted() ? "true" : "false");
    thread2.start();
    Thread.sleep(100);
    synchronized (x){
      x.notifyAll();
      System.out.println("4");
    }


  }

}
