package testConcurrent;

public class InterruptTest {

//  public static void main(String args[]) throws Exception {
//
//    Thread thread1 = new Thread(){
//      @Override
//      public void run() {
//        try {
//          while (true) {
////          if(Thread.interrupted()){
////            System.out.println("manba out 1");
////            break;
////          }
//
//            System.out.println("进循环");
//            if(Thread.interrupted()){
//              System.out.println("manba out 1 " + (Thread.interrupted() ? "true" : "false"));
//              Thread.sleep(1);
//            }
//
////            System.out.println("进循环");
////            if(this.isInterrupted()){
////              System.out.println("manba out 2 " + (this.isInterrupted() ? "true" : "false"));
////              Thread.sleep(1);
////            }
//              Thread.sleep(1);
//          }
//        } catch (Exception e) {
//          e.printStackTrace();
//        }
//      }
//    };
//    thread1.start();
//    Thread.sleep(1);
//    System.out.println("interrupt");
//    thread1.interrupt();
//    System.out.println("isInterrupted");
//    System.out.println(thread1.isInterrupted() ? "true" : "false");
//    System.out.println(thread1.isInterrupted() ? "true" : "false");
////    System.out.println("interrupted");
////    System.out.println(thread1.interrupted() ? "true" : "false");
////    System.out.println(thread1.interrupted() ? "true" : "false");
////    Thread.interrupted();
//  }
  public static void main(String args[]) throws Exception {
    Thread thread = new Thread() {
      @Override
      public void run() {
        try {
          System.out.println("开始休眠");
          Thread.sleep(360000);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    };
    thread.start();

    System.out.println("主线程开始休眠");
    Thread.sleep(1);
    System.out.println("主线程结束休眠");

    System.out.println("主线程中断子线程");
    thread.interrupt();
  }
}
