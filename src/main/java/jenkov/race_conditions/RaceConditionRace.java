package jenkov.race_conditions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RaceConditionRace {

  public static void main(String[] args) {

    Counter counter1 = new Counter();

    Thread thread1 = new Thread(getRunnable(counter1, "Thread1: "));
    Thread thread2 = new Thread(getRunnable(counter1, "Thread2: "));

    thread1.start();
    thread2.start();
  }

  static Runnable getRunnable(Counter counter, String message) {
    return () -> {
      for (int i = 0; i < 1_000_000; i++) {
        counter.incrementValue();
      }
      log.info(message + counter.getValue());
    };
  }
}
