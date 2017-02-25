package ru.msk.tkachenko.dmitry.schultetable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by dmitry tkachenko on 2/21/17.
 *
 * @author Dmitry Tkachenko
 * @version 1.0
 */
class Board extends JFrame {
    private final int ROWS;
    private final int COLS;
    private final int COUNT;
    private int clicks;
    private Tile tile;
    private JButton buttons[];
    private final char EMPTY = '*';
    private List numbers;
    private StatusBar statusBar;
    private int next;
    private Thread statusBarThread;
    private JMenuItem openItem;


    Board() {
        ROWS = 3;
        COLS = 3;
        COUNT = ROWS * COLS;
        defaultSetup();

        setup();
        setLocationRelativeTo(null);
        setupMenu();
    }

    private void defaultSetup() {
        this.tile = new Tile(new GridLayout(ROWS, COLS));
        this.buttons = new CustomButton[COUNT];
        this.numbers = fillList(COUNT);
        clicks = COUNT;
        next = 1;
        statusBar = new StatusBar(); // new FlowLayout()
    }

    private void removeComponents() {
        remove(tile);
        remove(statusBar);
    }

    private void setupMenu() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        openItem = new JMenuItem("New game");
        menu.add(openItem);

        openItem.addActionListener(e -> {
            removeComponents();
            defaultSetup();
            setup();
        });
    }

    private void setup() {
        setTitle("Schulte Board");
        setResizable(false);
        setSize(new Dimension(250, 250));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setupLayout();
        initButtons();

        setVisible(true);
    }

    private void setupLayout() {

        setLayout(new BorderLayout());

        add(tile, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);

    }

    private void initButtons() {
        Collections.shuffle(numbers);
        JButton btn;
        String title;

        for (int i = 0; i < COUNT; i++) {
            title = numbers.get(i).toString();
            btn = new CustomButton(title);
            btn.addActionListener(new TileListener());

            tile.add(btn);
        }
    }

    private List<String> fillList(int count) {
        count++;
        List<String> list = new ArrayList<>();

        for (int i = 1; i < count; i++) {
            list.add(String.valueOf(i));
        }

        return list;
    }

    private class TileListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() instanceof JButton) {
                JButton btn = (JButton) e.getSource();
                String nextStr = String.valueOf(next);
                String textBtn = btn.getText();

                if (nextStr.equals(textBtn) && !textBtn.equals("X")) {
                    btn.setText("X");
                    clicks--;
                    next++;
                } else {
                    statusBar.increaseWrongClick();
                    System.out.println("increase wrong click");
                }

                if (clicks == 0) {
                    statusBar.stopThread();
                }
            }
        }
    }
}
