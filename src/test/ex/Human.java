package test.ex;

import test.Parent;

import java.io.FileInputStream;

class Human {
  public static void main(String[] args)
          throws Exception {
    try {

      try {
        throw new Sneeze();
      } catch ( Annoyance a ) {
        System.out.println("Caught Annoyance");
        if(a instanceof Sneeze) {
          System.out.println("Zma");
        }
        throw a;
      }
    } catch ( Sneeze s ) {
      System.out.println("Caught Sneeze");
      return ;
    } finally {
      System.out.println("Hello World!");
    }
  }


}

