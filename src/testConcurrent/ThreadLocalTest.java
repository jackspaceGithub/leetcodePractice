package testConcurrent;

public class ThreadLocalTest {

  public static void main(String args[]) {

    // 基本用法实例
    ThreadLocal<Integer> X = new ThreadLocal<Integer>(){
      @Override
      protected Integer initialValue() {
        return 0;
      }
    };

    for (int i = 0; i < 3; i++) {
      new Thread(){
        @Override
        public void run() {
          Integer p = X.get();
          for(int i1 = 0; i1 < 5; i1++) {
            p++;
            System.out.println(Thread.currentThread().getName() + ": " + p);
          }
        }
      }.start();
    }

    for (int i = 0; i < 3; i++) {
      new Thread(){
        @Override
        public void run() {
          for(int i1 = 0; i1 < 5; i1++) {
            X.set(X.get() + 1);
            System.out.println(Thread.currentThread().getName() + ": " + X.get());
          }
        }
      }.start();
    }

    X.remove();

  }
}
