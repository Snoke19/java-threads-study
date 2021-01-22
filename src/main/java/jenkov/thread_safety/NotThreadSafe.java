package jenkov.thread_safety;

import lombok.Data;

@Data
public class NotThreadSafe {

  private StringBuilder builder = new StringBuilder();

  public void add(String text){
    this.builder.append(text);
  }
}
