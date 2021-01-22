package jenkov.race_conditions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RaceConditionsExample2 {

  public static void main(String[] args) {

    Counter counter = new Counter();

    Thread thread1 = new Thread(getRunnableWriteAndRead(counter));
    Thread thread2 = new Thread(getRunnableRead(counter));

    thread1.start();
    thread2.start();

  }

  static Runnable getRunnableWriteAndRead(Counter counter) {
    return () -> {
      for (int i = 0; i < 1_000_000; i++) {
        counter.incrementValue();
      }
      log.info("Thread1 final count: " + counter.getValue());
    };
  }

  static Runnable getRunnableRead(Counter counter) {
    return () -> {
      for (int i = 0; i < 5; i++) {

        try {
          Thread.sleep(2);
        } catch (InterruptedException e) {
          e.printStackTrace();
          Thread.currentThread().interrupt();
        }

        log.info("Thread2 count: " + counter.getValue());
      }
    };
  }
}
