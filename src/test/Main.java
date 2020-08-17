package test;

import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import test2.CC;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) throws Exception {

//    System.out.println("" + -3);
//    String str = "";
//    StringBuilder stringBuilder = new StringBuilder();
//    stringBuilder.reverse();
//    char[] x = new char[10];
//    String s = String.valueOf(x);
//
//    List<Integer> list = new ArrayList<>();
//    list.add(1);
//    list.add(2);
//
//    List<Integer> list2 = list.stream().filter(e -> e.equals(1)).collect(Collectors.toList());
//    System.out.println(list2);
    // break跳出多级循环问题
//    ok:
//    while(true) {
//      while (true) {
//        break ok;
//      }
//    }
//    System.out.println("Zma");
//
//    // 继承实现多态
//    Parent parent = new P();
//    parent.printWord();
//    parent = new Son();
//    parent.printWord();
//
//    // 接口实现多态
//    T1 t1 = new T1Imp();
//    t1.printName();
//    t1 = new T1Imp2();
//    t1.printName();

//    T1 t1 = new T1Imp();
//    t1.printV();
//    t1 = new T1Imp2();
//    t1.printV();

//    // 静态内部类
//    StaticInner staticInner = new StaticInner();
//    StaticInner.T2Static n = new StaticInner.T2Static();
//
//    // 成员内部类
//    MemberInner memberInner = new MemberInner();
//    MemberInner.Member member = memberInner.new Member();


    // 反射
//    Class<?> oneClass = Class.forName("test.Parent");
//    Parent object = oneClass.newInstance();
//    Method[] methods = oneClass.getMethods();
//    String name = oneClass.getName();
//    Field[] fields = oneClass.getFields();
//    Constructor<?> constructor = oneClass.getConstructor();
//    Parent parent = (Parent) constructor.newInstance();
//    Parent parent1 = parent.clone();
//
//    ObjectInputStream objectInputStream = new ObjectInputStream("");
//    objectInputStream.readObject();
//    // 反射出实例
//    Object object = oneClass.newInstance();
//    // 反射私有属性
//    Field field = oneClass.getDeclaredField("list");
//    field.setAccessible(true);
//    int[] list = (int[])field.get(object);
//    list[0] = 9;
//
//    Method method = oneClass.getDeclaredMethod("printWord", int.class);
//    method.setAccessible(true);
//    // 反射私有方法
//    method.invoke(object, 0);

//    String str = new String("xpxpx");
//    String str = "xpxpx";
//    Field field = String.class.getDeclaredField("value");
//    field.setAccessible(true);
//    char[] chars = (char[])field.get(str);
//    chars[1] = '3';
//    System.out.println(str);

//    final char[] chars = {'1','2'};
//    chars[0] = '9';
//    for(char c : chars) {
//      System.out.println(c);
//    }

//    System.out.println(str.indexOf('x'));
//    String[] strings = new String[]{"sfaa", "wefwef"};
//    List<String> list = new ArrayList<>();
//    list.add("s");
//
//      Collections.addAll(list, strings);
//    list = Arrays.asList(strings);
//    list.add("pp");
//    list.add("ww");
//    list.add("aa");
//    list.remove("ww");
//    System.out.println();
//    list.toArray();
//    Collections.unmodifiableCollection();
//    Collections.synchronizedCollection();
//    Iterator<String> iterator = list.iterator();
//    if (iterator.hasNext()) {
//      iterator.next();
//      iterator.remove();
//    }

//    for (String s : list) {
//      System.out.println(s);
//      list.remove("sfaa");
//    }
//
//    for (int i = 0; i < list.size(); i++) {
//      System.out.println(list.get(i));
//    }
//
//    Iterator<String> iterator2 = list.iterator();
//    while (iterator2.hasNext()) {
//      System.out.println(iterator2.next());
//    }
//
//    list.forEach(System.out::println);
//
//    Stack stack = new Stack();
//    if(stack instanceof Vector) {
//      System.out.println("Yes");
//    }

//    Enum;
//    Enumeration
//    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//    for (int i = 1; i < 66; i++) {
//      map.put(i, i);
//    }
//    map.get(1);

//    ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
//    concurrentHashMap.put();
//    Integer x = 1;
//    System.out.println(x.hashCode());
//    x = 3;
//    HashSet
//    Vector
//    Deque
//    Map
//    Stack;
//    BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>();
//    blockingQueue.add("St");
//    blockingQueue.remove();
//    Parent parent = new Parent();
//    System.out.println(parent.x);


    try (Parent parent = new Parent(new FileInputStream("D:\\mypro\\leetcodePractice\\src\\test\\3.txt"));) {
      System.out.println("try");
      throw new RuntimeException("fuck");
    } catch (Exception e) {
//      System.out.println("ZMA");
      e.printStackTrace();
//      e.addSuppressed(e);
//      Throwable[] throwables = e.getSuppressed();
//      for(Throwable throwable : throwables) {
//        throwable.printStackTrace();
//      }
//      System.out.println("ex");
//      e.printStackTrace();
    }

//    try{
//      ClassLoader systemClassLoader= ClassLoader.getSystemClassLoader();
//      Class aClass = systemClassLoader.loadClass("test2.CC");
//      Class aClass1 = Class.forName("test2.CC");
//      System.out.println(aClass.hashCode());
//      System.out.println(aClass1.hashCode());
//      throw new Exception();
//    } finally {
//
//    }
//    CC cc = new CC();
//    System.out.println("22");
////    List list = (List) cc;
////    System.out.println(cc instanceof String ? "1" : "2");
//    List list = (List)cc;
//    System.out.println("33");
//    System.out.println(cc instanceof List ? "1" : "2");
//    CC cc = null;
//    System.out.println(cc instanceof CC ? "1" : "2");

//    Thread thread = new Thread();
//    thread.setDaemon(true);
//    thread.start();

//    new Thread() {
//      public void run() {
//        try {
//          Thread.sleep(100);
//          System.out.println("匿名内部类实现线程1");
//        } catch (Exception e) {
//          System.out.println("e了1");
//        }
//      }
//    }.start();
//
//    new Thread() {
//      public void run() {
//        try {
//          System.out.println("匿名内部类实现线程2");
//        } catch (Exception e) {
//          System.out.println("e了2");
//        }
//      }
//    }.start();

//    Thread thread1 = new Thread(
//      new Runnable() {
//        @Override
//        public void run() {
//          System.out.println("Runnable");
//        }
//      }
//    );
//
//    FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
//      @Override
//      public String call() throws Exception {
//        System.out.println("call 0");
//        Thread.sleep(100);
//        System.out.println("call 1");
//        return System.currentTimeMillis() + " over";
//      }
//    });
//
//    Thread thread = new Thread(futureTask);
//    thread.setDaemon(true);
//    thread.start();
//    System.out.println(futureTask.get());
//
//    System.out.println("Main 0");
//    Thread.sleep(1);
//    System.out.println("Main 2");
//    System.out.println(futureTask.get());


//    ExecutorService executorService = Executors.newFixedThreadPool(2);
//    new ThreadPoolExecutor();
//    Executors.newCachedThreadPool();
//    Executors.newScheduledThreadPool(2);
//    Executors.newSingleThreadExecutor();
  }

}
