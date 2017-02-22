package ru.msk.tkachenko.dmitry.schultetable;

import javax.swing.*;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 2/21/17
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Board::new);
    }
}
