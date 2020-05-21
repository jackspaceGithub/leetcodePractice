package test.ex;

import test.Parent;

import java.io.FileInputStream;

public class TryWithResource {

  public static void main(String args[]) {


    try (Parent parent = new Parent(new FileInputStream("D:\\mypro\\leetcodePractice\\src\\test\\3.txt"));) {
      System.out.println("try");
      throw new RuntimeException("fuck");
    } catch (Exception e) {
      System.out.println("ZMA");
      e.printStackTrace();
//      e.addSuppressed(e);
//      Throwable[] throwables = e.getSuppressed();
//      for(Throwable throwable : throwables) {
//        throwable.printStackTrace();
//      }
//      System.out.println("ex");
//      e.printStackTrace();
    }

  }
}
