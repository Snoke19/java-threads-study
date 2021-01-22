package jenkov.synchronized_examples.example1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunnableCountingInt implements Runnable {

  private final CounterExecutor counterExecutor = new CounterExecutor();

  @Override
  public void run() {

    for (int i = 0; i < 5; i++) {
      this.counterExecutor.setValue(i);

      log.info(Thread.currentThread().getName() + " " + this.counterExecutor.getValueInt());
    }
  }
}
