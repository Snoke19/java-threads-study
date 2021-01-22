package jenkov.thread_safety;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotThreadSafeMain {
  public static void main(String[] args) {

    NotThreadSafe sharedInstance = new NotThreadSafe();

    new Thread(new MyRunnable(sharedInstance)).start();
    new Thread(new MyRunnable(sharedInstance)).start();
  }

  static class MyRunnable implements Runnable{
    NotThreadSafe instance;

    public MyRunnable(NotThreadSafe instance){
      this.instance = instance;
    }

    @Override
    public void run(){
      this.instance.add("some text");
      log.info(Thread.currentThread().getName() + " " + instance.toString());
    }
  }
}
