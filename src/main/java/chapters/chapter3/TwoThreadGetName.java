package chapters.chapter3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TwoThreadGetName extends Thread {

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      this.printMsg();
    }
  }

  public void printMsg() {
    Thread t = Thread.currentThread();
    String name = t.getName();
    log.info("name = " + name);
  }

  public static void main(String[] args) {

    TwoThreadGetName tt = new TwoThreadGetName();
    tt.start();

    for (int i = 0; i < 10; i++) {
      tt.printMsg();
    }
  }
}
