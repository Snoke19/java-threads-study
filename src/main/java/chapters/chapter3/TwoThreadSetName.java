package chapters.chapter3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TwoThreadSetName extends Thread {

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
    tt.start();

    for (int i = 0; i < 10; i++) {
      tt.printMsg();
    }
  }
}
