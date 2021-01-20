package chapters.chapter2.example5;

import chapters.chapter2.CharacterEventHandler;
import chapters.chapter2.CharacterListener;
import chapters.chapter2.CharacterSource;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class RandomCharacterGenerator implements CharacterSource, Runnable {

  static char[] chars;
  static String charArray = "abcdefghijklmnopqrstuvwxyz0123456789";
  static {
    chars = charArray.toCharArray();
  }

  Random random;
  CharacterEventHandler handler;

  private volatile boolean done = false;

  public RandomCharacterGenerator() {
    random = new Random();
    handler = new CharacterEventHandler();
  }

  public int getPauseTime() {
    return (int) (Math.max(1000, 5000 * random.nextDouble()));
  }

  public void addCharacterListener(CharacterListener cl) {
    handler.addCharacterListener(cl);
  }

  public void removeCharacterListener(CharacterListener cl) {
    handler.removeCharacterListener(cl);
  }

  public void nextCharacter() {
    handler.fireNewCharacter(this,
      (int) chars[random.nextInt(chars.length)]);
  }

  public void run() {
    while (!done) {
      nextCharacter();
      try {
        Thread.sleep(34);
      } catch (InterruptedException ie) {
        log.info("InterruptedException: " + ie.getMessage());
        return;
      }
    }
  }

  public void setDone() {
    done = true;
  }

}
