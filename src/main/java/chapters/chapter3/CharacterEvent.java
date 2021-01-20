package chapters.chapter3;

import lombok.Data;

@Data
public class CharacterEvent {

  public CharacterSource source;
  public int character;

  public CharacterEvent(CharacterSource cs, int c) {
    source = cs;
    character = c;
  }
}
