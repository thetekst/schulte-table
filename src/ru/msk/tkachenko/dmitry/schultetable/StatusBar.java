package ru.msk.tkachenko.dmitry.schultetable;

import javax.swing.*;
import java.awt.*;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 2/21/17
 */
public class StatusBar extends JPanel implements Runnable {
    private Thread thread;
    private int sec;
    private JLabel labelCounter;
    private JLabel wrongClickLabel;
    private int wrongClickingCounter;
    private boolean isContinue;

    StatusBar() { //LayoutManager layout
        super(new BorderLayout());

        isContinue = true;
        labelCounter = new JLabel(String.valueOf(sec));
        wrongClickingCounter = 0;
        wrongClickLabel = new JLabel(String.valueOf(wrongClickingCounter));
        add(wrongClickLabel, BorderLayout.WEST);
        add(labelCounter, BorderLayout.EAST);
        this.thread = new Thread(this, "threadname");
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        System.out.println("1");
//        label.setText(String.valueOf(sec));
    }


    @Override
    public void run() {
        String labelStr;

        try {
            while (isContinue) {

                labelStr = String.format("%d", sec);
                if (sec < 10) labelStr = String.format("0%s", labelStr);
                labelCounter.setText(labelStr);
                sec++;
                Thread.sleep(1000);
//                repaint();
//                revalidate();
            }

        } catch (Exception ignored) {
        }

    }

    private void update() {

    }

    void stopThread() {
        isContinue = false;
    }

    public void increaseWrongClick() {
        wrongClickingCounter++;
    }
}
