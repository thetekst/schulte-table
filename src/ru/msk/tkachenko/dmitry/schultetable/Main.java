package ru.msk.tkachenko.dmitry.schultetable;

import javax.swing.*;

/**
 * Created by dmitry tkachenko on 2/21/17.
 *
 * @author Dmitry Tkachenko
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new Board(5, 5));
    }
}
