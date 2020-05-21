package test;

import java.io.FileInputStream;
import java.io.IOException;

public class Parent implements AutoCloseable {

  int x;

  public FileInputStream fileInputStream;

  public Parent() {

  }

  public FileInputStream getFileInputStream() {
    return fileInputStream;
  }

  public void setFileInputStream(FileInputStream fileInputStream) {
    this.fileInputStream = fileInputStream;
  }


  public Parent(FileInputStream fileInputStream) {

    this.fileInputStream = fileInputStream;

  }

  private int[] list = {1,2,3};


  private void printWord(int x1) {
    System.out.println("Parent" + x1);
  }

  public Parent clone() {
    Parent copy = null;
    try {
      copy = (Parent)super.clone();
    } catch (CloneNotSupportedException e) {

    }
    return copy;
  }

  public void test1() throws RuntimeException {
    throw new RuntimeException();
  }

  @Override
  public void close() throws Exception {
    System.out.println("close");
    throw new IOException("sad");
  }
}
