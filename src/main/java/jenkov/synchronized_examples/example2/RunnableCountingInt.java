package jenkov.synchronized_examples.example2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunnableCountingInt implements Runnable {

  private final CounterExecutor counterExecutor;

  public RunnableCountingInt(CounterExecutor counterExecutor) {
    this.counterExecutor = counterExecutor;
  }

  @Override
  public void run() {

    for (int i = 0; i < 10; i++) {
      this.counterExecutor.setValue(i);
    }

    log.info(Thread.currentThread().getName() + " " + this.counterExecutor.getValueInt());
  }
}
