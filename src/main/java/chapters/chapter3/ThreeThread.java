package chapters.chapter3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreeThread extends Thread {

  private final Thread creatorThread;

  public ThreeThread() {
    creatorThread = Thread.currentThread();
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      printMsg();
    }
  }

  public void printMsg() {
    // get a reference to the thread running this
    Thread t = Thread.currentThread();

    if (t == creatorThread) {
      log.info("Creator thread");
    } else if (t == this) {
      log.info("New thread");
    } else {
      log.info("Mystery thread — unexpected !");
    }
  }

  public static void main(String[] args) {
    ThreeThread tt = new ThreeThread();
    tt.start();

    for (int i = 0; i < 10; i++) {
      tt.printMsg();
    }
  }
}
