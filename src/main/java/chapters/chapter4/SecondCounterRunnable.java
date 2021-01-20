package chapters.chapter4;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

@Slf4j
public class SecondCounterRunnable extends JComponent implements Runnable {

  private volatile boolean keepRunning;
  private final Font paintFont;
  private volatile String timeMsg;
  private volatile int arcLen;


  public SecondCounterRunnable() {
    paintFont = new Font("SansSerif", Font.BOLD, 14);
    timeMsg = "never started";
    arcLen = 0;
  }

  public void run() {
    this.runClock();
  }

  public void runClock() {

    log.info("thread running runClock() is " + Thread.currentThread().getName());

    DecimalFormat fmt = new DecimalFormat(" 0.000");
    long normalSleepTime = 100;

    int counter = 0;
    keepRunning = true;

    while (keepRunning) {
      try {
        Thread.sleep(normalSleepTime);
      } catch (InterruptedException x) {
        log.info("InterruptedException: " + x.getMessage());
        Thread.currentThread().interrupt();
      }

      counter++;
      double counterSecs = counter / 10.0;

      timeMsg = fmt.format(counterSecs);

      arcLen = (((int) counterSecs) % 60) * 360;

      log.info(Thread.currentThread().getName());

      this.repaint();
    }
  }

  public void stopClock() {
    keepRunning = false;
  }

  @Override
  public void paint(Graphics g) {

    log.info("thread that invoked paint() is " + Thread.currentThread().getName());

    g.setColor(Color.black);
    g.setFont(paintFont);
    g.drawString(timeMsg, 0, 15);

    g.fillOval(0, 20, 100, 100); // black border

    g.setColor(Color.white);
    g.fillOval(3, 23, 94, 94); // white for unused portion

    g.setColor(Color.blue); // blue for used portion
    g.fillArc(2, 22, 96, 96, 90, -arcLen);
  }
}