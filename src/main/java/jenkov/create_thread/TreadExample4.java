package jenkov.create_thread;

public class TreadExample4 {

  public static void main(String[] args) {

    Runnable myRunnable = () -> {
      String name = Thread.currentThread().getName();
      System.out.println("MyThread " + name + " running!");
      System.out.println("MyThread " + name + " finished!");
    };

    Thread thread = new Thread(myRunnable);
    thread.start();

    Thread thread1 = new Thread(myRunnable);
    thread1.start();
  }
}
