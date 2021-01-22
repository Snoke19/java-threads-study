package jenkov.synchronized_examples.example3;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Counter {

  private long str;

  public void add(long value){
    this.str += value;
  }
}
