package test2;

// 单例模式练习 饿汉式
//public class SingleTest {
//
//  private int x;
//
//  private static SingleTest singleTest = new SingleTest();
//
//  private SingleTest(){
//    x = 1;
//  }
//
//  public static SingleTest get() {
//    return singleTest;
//  }
//}


// 单例模式练习 懒汉式
public class SingleTest {

  private int x;

  private static SingleTest singleTest;
  private static Integer Y = 9;

  private SingleTest(){
    x = 1;
  }

  public static SingleTest get() {
    if(singleTest == null) {
      synchronized (Y) {
        if(singleTest == null)
          singleTest = new SingleTest();
      }
    }
    return singleTest;
  }
}