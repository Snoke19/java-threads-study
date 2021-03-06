package chapters.chapter3.example3;

import chapters.chapter3.CharacterDisplayCanvas;
import chapters.chapter3.CharacterEvent;
import chapters.chapter3.CharacterListener;
import chapters.chapter3.CharacterSource;

import java.awt.*;

public class AnimatedCharacterDisplayCanvas extends CharacterDisplayCanvas implements CharacterListener, Runnable {

  private volatile boolean done = false;
  private int curX = 0;

  public AnimatedCharacterDisplayCanvas() {
  }

  public AnimatedCharacterDisplayCanvas(CharacterSource cs) {
    super(cs);
  }

  public synchronized void newCharacter(CharacterEvent ce) {
    curX = 0;
    tmpChar[0] = (char) ce.character;
    repaint();
  }

  @Override
  protected synchronized void paintComponent(Graphics gc) {
    Dimension d = getSize();
    gc.clearRect(0, 0, d.width, d.height);
    if (tmpChar[0] == 0)
      return;

    gc.drawChars(tmpChar, 0, 1,
      curX++, fontHeight);
  }

  @Override
  public void run() {
    while (!done) {
      repaint();
      try {
        Thread.sleep(100);
      } catch (InterruptedException ie) {
        return;
      }
    }
  }

  public void setDone(boolean b) {
    done = b;
  }
}
