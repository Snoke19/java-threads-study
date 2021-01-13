package chapters.chapter2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TwoThread extends Thread {

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      log.info("New thread");
    }
  }

  public static void main(String[] args) {
    TwoThread tt = new TwoThread();
    tt.start();

    for (int i = 0; i < 10; i++) {
      log.info("Main thread");
    }
  }
}

