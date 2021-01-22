package jenkov.synchronized_examples.example1;

import lombok.Getter;

@Getter
public class CounterExecutor {

  private int valueInt;
  private double valueDouble;

  public void setValue(int valueInt) {
    this.valueInt = valueInt;
  }

  public void setValueDouble(double valueDouble) {
    this.valueDouble = valueDouble;
  }
}
