package chapters.chapter2.example5;

import chapters.chapter2.CharacterDisplayCanvas;
import chapters.chapter2.CharacterEventHandler;
import chapters.chapter2.CharacterListener;
import chapters.chapter2.CharacterSource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingTypeTester extends JFrame implements CharacterSource {

  protected RandomCharacterGenerator producer;
  private CharacterDisplayCanvas displayCanvas;
  private CharacterDisplayCanvas feedbackCanvas;
  private JButton quitButton;
  private JButton startButton;
  private JButton stopButton;
  private CharacterEventHandler handler;

  public SwingTypeTester() {
    initComponents();
  }

  private void initComponents() {
    handler = new CharacterEventHandler();
    displayCanvas = new CharacterDisplayCanvas();
    feedbackCanvas = new CharacterDisplayCanvas(this);
    quitButton = new JButton();
    startButton = new JButton();
    stopButton = new JButton();
    add(displayCanvas, BorderLayout.NORTH);
    add(feedbackCanvas, BorderLayout.CENTER);
    JPanel p = new JPanel();
    startButton.setLabel("Start");
    stopButton.setLabel("Stop");
    quitButton.setLabel("Quit");
    p.add(startButton);
    p.add(stopButton);
    p.add(quitButton);
    add(p, BorderLayout.SOUTH);

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) {
        quit();
      }
    });

    feedbackCanvas.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent ke) {
        char c = ke.getKeyChar();
        if (c != KeyEvent.CHAR_UNDEFINED)
          newCharacter((int) c);
      }
    });
    startButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        producer = new RandomCharacterGenerator();
        displayCanvas.setCharacterSource(producer);
        Thread t = new Thread(producer);
        t.start();
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
        feedbackCanvas.setEnabled(true);
        feedbackCanvas.requestFocus();
      }
    });
    stopButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        producer.setDone();
        feedbackCanvas.setEnabled(false);
      }
    });
    quitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        quit();
      }
    });


    pack();
  }

  private void quit() {
    System.exit(0);
  }

  public void addCharacterListener(CharacterListener cl) {
    handler.addCharacterListener(cl);
  }

  public void removeCharacterListener(CharacterListener cl) {
    handler.removeCharacterListener(cl);
  }

  public void newCharacter(int c) {
    handler.fireNewCharacter(this, c);
  }

  public void nextCharacter() {
    throw new IllegalStateException("We don't produce on demand");
  }

  public static void main(String args[]) {
    new SwingTypeTester().show();
  }
}
