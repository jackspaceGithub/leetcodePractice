package testConcurrent;

import java.util.ArrayList;

/**
 * 主存和工作内存
 */
public class WorkingMemAndMainMem {

  public static void main(String[] args) {

    Integer[] x = {0};
//    ArrayList<Integer> list = new ArrayList<>();
//    list.forEach(e -> {
//      args[0] = "e";
//      System.out.println();
//    });

    // 试一下两个线程同时修改工作内存， 可以看到有重复数字，说明缓存生效
    Thread thread1 = new Thread(){
      public void run() {
        for(int i = 0; i < 5; i++) {
          System.out.println("Thread1: " + ++x[0]);
        }
      }
    };

    Thread thread2 = new Thread(){
      public void run() {
        for(int i = 0; i < 5; i++) {
          System.out.println("Thread2: " + ++x[0]);
        }
      }
    };

    thread1.start();
    thread2.start();

  }


}
