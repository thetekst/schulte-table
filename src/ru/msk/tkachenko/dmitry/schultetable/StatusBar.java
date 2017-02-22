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
    private JLabel label;
    private boolean isContinue;

    StatusBar(LayoutManager layout) {
        super(layout);

        isContinue = true;
        label = new JLabel(String.valueOf(sec));
        add(label);
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
                label.setText(labelStr);
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
}
