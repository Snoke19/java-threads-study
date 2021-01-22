package jenkov.synchronized_examples.example1;

public class MainThread {
  public static void main(String[] args) {

    Thread thread1 = new Thread(new RunnableCountingInt());
    Thread thread2 = new Thread(new RunnableCountingInt());

    thread1.start();
    thread2.start();
  }
}
