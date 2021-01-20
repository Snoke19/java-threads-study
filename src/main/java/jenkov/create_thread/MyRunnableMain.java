package jenkov.create_thread;

public class MyRunnableMain {

  public static void main(String[] args) {
    MyRunnable myRunnable = new MyRunnable();

    Thread thread = new Thread(myRunnable);

    thread.start();

    try {
      Thread.sleep(100L * 1000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    myRunnable.doStop();
  }
}