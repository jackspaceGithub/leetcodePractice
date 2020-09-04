package testConcurrent;

public class ThreadEXTest {

  public static void main(String args[]) throws Exception {


    Thread thread1 = new Thread(){
      @Override
      public void run() {
        throw new RuntimeException("异常终止线程");
      }
    };

    thread1.start();
    System.out.println("主线程运行");
    thread1.interrupt();
    thread1.isInterrupted();
//    thread1.getUncaughtExceptionHandler().uncaughtException(thread1, );
  }
}
