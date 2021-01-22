package jenkov.synchronized_examples.example3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CounterThread extends Thread {

  protected Counter counter;

  public CounterThread(Counter counter) {
    this.counter = counter;
  }

  @Override
  public void run() {
    for (int i = 0; i < 1_000_000; i++) {
      counter.add(i);
    }

    log.info(Thread.currentThread().getName() + " - " + counter.getStr());
  }
}
