package ru.msk.tkachenko.dmitry.schultetable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by dmitry tkachenko on 2/21/17.
 *
 * @author Dmitry Tkachenko
 * @version 1.0
 */
public class Board extends JFrame {
    private final int ROWS;
    private final int COLS;
    private final int COUNT;
    private Tile tile;
    private JButton buttons[];
    private final char EMPTY = '*';
    private List numbers;


    public Board(int rows, int cols) {
        ROWS = rows;
        COLS = cols;
        COUNT = ROWS * COLS;
        this.tile = new Tile(new GridLayout(ROWS, COLS));
        this.buttons = new CustomButton[COUNT];
        this.numbers = fillList(COUNT);

        setup();
    }

    private void setup() {
        setTitle("Schulte Board");
        setResizable(false);
        setSize(new Dimension(250, 250));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setupLayout();
        initButtons();

        setVisible(true);
    }

    private void setupLayout() {
        setLayout(new BorderLayout());
        add(tile, BorderLayout.CENTER);
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
        List<String> list = new ArrayList<String>();

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
                btn.setText("X");
            }

        }
    }
}
