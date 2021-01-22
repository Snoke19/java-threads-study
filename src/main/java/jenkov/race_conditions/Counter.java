package jenkov.race_conditions;

import lombok.Getter;

@Getter
public class Counter {

  private int value = 0;

  public void incrementValue() {
    this.value++;
  }
}
