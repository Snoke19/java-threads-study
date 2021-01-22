package jenkov.synchronized_examples.example2.test;

public class Second extends Thread {
  String msg;
  First fobj;

  Second(First fp, String str) {
    fobj = fp;
    msg = str;
    start();
  }

  @Override
  public void run() {
    fobj.display(msg);
  }
}