package test;

public class T1Imp2 implements T1 {

  public void printName(){
      System.out.println("T2");
  }

  public static void main(String args[]) {
    T1Imp2 t1Imp2 = new T1Imp2();
    t1Imp2.printV();
  }
}
