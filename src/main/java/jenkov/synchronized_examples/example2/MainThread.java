package jenkov.synchronized_examples.example2;

public class MainThread {
  public static void main(String[] args) {

    CounterExecutor counterExecutor = new CounterExecutor();
    RunnableCountingInt runnableCountingInt = new RunnableCountingInt(counterExecutor);

    Thread thread1 = new Thread(runnableCountingInt);
    Thread thread2 = new Thread(runnableCountingInt);

    thread1.start();
    thread2.start();
  }
}
