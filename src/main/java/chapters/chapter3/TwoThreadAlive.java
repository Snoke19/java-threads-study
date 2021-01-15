package chapters.chapter3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TwoThreadAlive extends Thread {

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      printMsg();
    }
  }

  public void printMsg() {
    Thread t = Thread.currentThread();
    String name = t.getName();
    log.info("name = " + name);
  }

  public static void main(String[] args) {
    TwoThreadSetName tt = new TwoThreadSetName();
    tt.setName("my worker thread");

    log.info("before start(), tt.isAlive()= " + tt.isAlive());
    tt.start();
    log.info("just after start(), tt.isAlive()= " + tt.isAlive());

    for (int i = 0; i < 10; i++) {
      tt.printMsg();
    }

    log.info("at the end of main(), tt.isAlive() = " + tt.isAlive());
  }
}
