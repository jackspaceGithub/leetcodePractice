package test;

class MemberInner {

    int x;

    class Member{
      public void visit() {
        System.out.println(x);
      }
    }
}
