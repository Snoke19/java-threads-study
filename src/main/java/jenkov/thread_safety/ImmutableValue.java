package jenkov.thread_safety;

public class ImmutableValue {

  private int value;

  public ImmutableValue(int value){
    this.value = value;
  }

  public int getValue(){
    return this.value;
  }

  public ImmutableValue add(int valueToAdd){
    return new ImmutableValue(this.value + valueToAdd);
  }
}
