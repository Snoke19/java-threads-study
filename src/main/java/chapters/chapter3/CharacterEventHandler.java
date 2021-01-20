package chapters.chapter3;

import java.util.*;

public class CharacterEventHandler {

  private final ArrayList<CharacterListener> listeners = new ArrayList<>();

  public void addCharacterListener(CharacterListener cl) {
    listeners.add(cl);
  }

  public void removeCharacterListener(CharacterListener cl) {
    listeners.remove(cl);
  }

  public void fireNewCharacter(CharacterSource source, int c) {
    CharacterEvent ce = new CharacterEvent(source, c);
    CharacterListener[] cl = listeners.toArray(new CharacterListener[0]);

    for (CharacterListener characterListener : cl) {
      characterListener.newCharacter(ce);
    }
  }
}
