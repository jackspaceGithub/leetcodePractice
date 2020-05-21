package test;

public class StaticInner {

  static int x = 1;
  static class T2Static {
    public void visit() {
      System.out.println(x);
    }
  }
}
