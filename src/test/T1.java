package test;

public interface T1 {

  int x = 0;
  void printName();

  default void printV() {
    System.out.println("T1V");
  }

  static void printS() {

  }
}
