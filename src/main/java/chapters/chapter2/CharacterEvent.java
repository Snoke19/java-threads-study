package chapters.chapter2;

import lombok.Data;

@Data
public class CharacterEvent {

  private CharacterSource source;
  private int character;

  public CharacterEvent(CharacterSource cs, int c) {
    source = cs;
    character = c;
  }

}
