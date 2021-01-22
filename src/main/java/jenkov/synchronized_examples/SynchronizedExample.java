package jenkov.synchronized_examples;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

@Slf4j
public class SynchronizedExample {

  public static void main(String[] args) {

    Consumer<String> func = (String param) -> {

      synchronized (SynchronizedExample.class) {

        log.info(Thread.currentThread().getName() + " step 1: " + param);

        try {
          Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
          e.printStackTrace();
          log.info("InterruptedException: " + e.getMessage());
          Thread.currentThread().interrupted();
        }

        log.info(Thread.currentThread().getName() + " step 2: " + param);
      }
    };


    Thread thread1 = new Thread(() -> func.accept("Parameter"), "Thread 1");

    Thread thread2 = new Thread(() -> func.accept("Parameter"), "Thread 2");

    thread1.start();
    thread2.start();
  }
}
