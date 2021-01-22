package jenkov.synchronized_examples.example2.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class First {

  public void display(String msg) {
    log.info("[" + msg);
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
      Thread.currentThread().interrupt();
    }
    log.info("]");
  }
}
