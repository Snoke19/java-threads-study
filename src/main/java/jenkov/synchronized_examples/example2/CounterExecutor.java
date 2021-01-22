package jenkov.synchronized_examples.example2;

public class CounterExecutor {

  private long valueInt = 0;

  public void setValue(long valueInt) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
      Thread.currentThread().interrupt();
    }
    this.valueInt += valueInt;
  }

  public long getValueInt() {
    return valueInt;
  }
}
